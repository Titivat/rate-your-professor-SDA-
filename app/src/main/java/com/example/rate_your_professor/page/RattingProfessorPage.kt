package com.example.rate_your_professor.page

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rate_your_professor.api.ProfessorInfoApi
import com.example.rate_your_professor.R
import com.example.rate_your_professor.model.apiCall.couseCode.CouseCode
import com.example.rate_your_professor.model.apiCall.studentComment.CommentData
import com.example.rate_your_professor.model.apiCall.summitInfo.SummitModel
import kotlinx.android.synthetic.main.activity_ratting_profesos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.toTypedArray as toTypedArray1

class RattingProfessorPage : AppCompatActivity() {
    private lateinit var couseCodeAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratting_profesos)
        val intent = intent
        val teacherInfo = intent.getSerializableExtra("TeacherInfo") as HashMap<String, String>?

        bthBack.setOnClickListener{
            startActivity(Intent(this, ProfesorInfoPage::class.java).putExtra("TeacherInfo", teacherInfo))
        }

        btnSummit.setOnClickListener{
            this.handleSummit()
        }

        var couseCodes = ArrayList<String>()
        this.getCouse(teacherInfo?.get("id") )

        couseCodeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, couseCodes)
        couseCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        etCouseCode.adapter = couseCodeAdapter;

    }

    private fun handleSummit(){
        val comment = etComment.text.toString()
        val causeCode = etCouseCode.selectedItem.toString()
        val rateProfessor = sbRate.progress
        val grade = spGrade.selectedItem.toString()
        val difficulty = sbDifficulty.progress
        val haveTakeAgain = swTakeAgain.isChecked
        val haveTakeCredit = swTakeCredit.isChecked
        val haveTextBook = swTextBook.isChecked
        val haveAttendance = swAttendance.isChecked

        val data = SummitModel(
                causeCode,
                rateProfessor.toFloat(),
                difficulty.toFloat(),
                haveTakeAgain,
                haveTakeCredit,
                haveTextBook,
                haveAttendance,
                grade,
                comment
        )

        this.summitData(data)
    }

    private fun summitData(data: SummitModel) {
        ProfessorInfoApi().postSummit( data ).enqueue( object : Callback<SummitModel> {
            override fun onFailure(call: Call<SummitModel>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<SummitModel>, response: Response<SummitModel>) {
                if (response.isSuccessful){
                    Toast.makeText(this@RattingProfessorPage,"Successful",Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    private fun getCouse(couseId: String?){
        if (couseId != null) {
            ProfessorInfoApi().getCouseCode( couseId ).enqueue(object : Callback<CouseCode> {
                override fun onFailure(call: Call<CouseCode>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<CouseCode>, response: Response<CouseCode>) {
                    response.body()?.let {
                        getResponse( it )
                    }
                }

            })
        }
    }

    private fun getResponse(codesList: CouseCode){
        Log.v("xxxxxx", "element" )
        var list = listOf<String>()
        list  = codesList.codes
        for( item in list){
            couseCodeAdapter.add( item )
        }
    }
}