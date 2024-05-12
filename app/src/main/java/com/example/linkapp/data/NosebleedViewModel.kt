package com.example.linkapp.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.linkapp.models.Product
import com.example.linkapp.models.nosebleed
import com.example.linkapp.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


class NosebleedViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel: AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadInstruction(instruction1:String,filePath:Uri){
        val productId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("nosebleeds/$productId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var ins = nosebleed(instruction1,imageUrl,productId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Products/Id")
                    databaseRef.setValue(instruction1).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allInstructions(
        Instruction:MutableState<Product>,
        Instructions:SnapshotStateList<Product>):SnapshotStateList<Product>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("nosebleeds")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Instructions.clear()
                for (snap in snapshot.children){
                    var retrievedProduct = snap.getValue(Product::class.java)
                    Instruction.value = retrievedProduct!!
                    Instructions.add(retrievedProduct)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return Instructions
    }

    fun deleteInstruction(Instruction1:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("nosebleeds/Id")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}