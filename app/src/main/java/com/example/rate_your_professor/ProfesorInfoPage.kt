package com.example.rate_your_professor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.profesor_information_page.*
import kotlinx.android.synthetic.main.teacher_item.view.*

class ProfesorInfoPage : AppCompatActivity() {
    private lateinit var studentCommentAdapter: StudentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profesor_information_page )
        val intent = intent
        val teacherInfo = intent.getSerializableExtra("TeacherInfo") as HashMap<String, String>?

        tvInfoRatting.text = teacherInfo?.get("teacherName")
        tvInfoName.text = teacherInfo?.get("ratting") + "/5"
        tvInfoAgainPercent.text = teacherInfo?.get("takeAgainPercent") + "%"
        tvInfoDifficulty.text = teacherInfo?.get("difficultyLevel")

        btnInfoBack.setOnClickListener{
            startActivity(Intent(this, MainActivityPage::class.java))
        }

        btnRateProfessor.setOnClickListener{
            val intent = Intent(this, RattingProfesorPage::class.java)
            intent.putExtra("TeacherInfo", teacherInfo)
            startActivity(intent)
        }

        studentCommentAdapter = StudentAdapter( mutableListOf() )

        this.requestApi()

        rvStudentComment.adapter = studentCommentAdapter
        rvStudentComment.layoutManager = LinearLayoutManager( this)

    }

    fun requestApi(){
        var item1 = StudentCommnetInfo("DSCI202","Yes","Not Mandatory","B","No","Worst class I have ever taken and by far the hardest. But it wasn't the stats that made it hard. We had 12 hrs only every Wed. to watch hours of lectures and take multiple quizzes. Haug is a smart guy, but so smart that he can't dumb it down for the rest of us. Just try to get as many points as possible and opt out of the final to keep the C.\n","1.0","5.0")
        studentCommentAdapter.addTodo( item1 )

        var item2 = StudentCommnetInfo("BSAN202","Yes","Not Mandatory","C","No","I never had a C in my life until I took this class, I had a perfect score on the HQLs so I thought the exam would be similar to the quizzes and labs from the class. I was wrong, the exam was way different from what I expected and ended having a C.","2.0","5.0")
        studentCommentAdapter.addTodo( item2 )

        var item3 = StudentCommnetInfo("BUS450","Yes","Not Mandatory","c"," No","Lengthy lectures were just Prof Haug reading numbers off a slide, no explanations. This class is nearly impossible for people with no prior statistics experience. Ridiculous grading, only matters what you get on the final (don't take it if you're not confident). Rely on your TA because that's the only teaching going on. Do the lab work before lab.\n","3.0","5.0")
        studentCommentAdapter.addTodo( item3 )

        var item4 = StudentCommnetInfo("DSCI205","Yes","Not Mandatory","A","No","Make no mistake, this will most likely be the most difficult class you will take at the B-school. The class builds on itself and it is critical that you keep up with the work. Rely on the example problems for quizzes and go to TA office hours. Haug is a caring professor, even if the grades don't reflct that.\n","5.0","5.0")
        studentCommentAdapter.addTodo( item4 )
    }

}
