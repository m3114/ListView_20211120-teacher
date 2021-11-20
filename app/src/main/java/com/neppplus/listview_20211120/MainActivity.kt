package com.neppplus.listview_20211120

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.neppplus.listview_20211120.adapters.StudentAdapter
import com.neppplus.listview_20211120.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mStudentAdapter: StudentAdapter
    val mStudentList = ArrayList<StudentData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(StudentData("구영모",1990, "경기도 부천시"))
        mStudentList.add(StudentData("김정난",1976, "서울시 용산구"))
        mStudentList.add(StudentData("김정환",1981, "서울시 중랑구"))
        mStudentList.add(StudentData("김찬수",1996, "서울시 성북구"))
        mStudentList.add(StudentData("김창배",1993, "서울시 노원구"))
        mStudentList.add(StudentData("성연진",1994, "서울시 성동구"))
        mStudentList.add(StudentData("윤성노",1974, "서울시 중랑구"))
        mStudentList.add(StudentData("최연주",1985, "서울시 성북구"))

        mStudentAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        studentListView.adapter = mStudentAdapter

        studentListView.setOnItemClickListener{addContentView,view, position,l ->
            val clilkedStudent = mStudentList[position]

//            Toast.makeText(this, "${clilkedStudent.name}클릭됨", Toast.LENGTH_SHORT).show()
            val myIntent = Intent(this, ViewStudentDatellActivity::class.java)
            myIntent.putExtra("name", clilkedStudent.name)
            myIntent.putExtra("age", clilkedStudent.getAgeByYear(2021))
            myIntent.putExtra("address", clilkedStudent.address)

            startActivity(myIntent)

        }

        studentListView.setOnItemLongClickListener{addContentView, view, position, l ->
            val longClickedStudent = mStudentList[position]

//            Toast.makeText(this, "${longClickedStudent.name} 길게 클릭됨", Toast.LENGTH_SHORT).show()
// 학생제거전에 삭제할건지 물어보자 alertdialog

            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 삭제 확인")
            alert.setMessage("정말!${longClickedStudent.name} ??학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->

                mStudentList.remove(longClickedStudent)

                mStudentAdapter.notifyDataSetChanged()
//                확인버튼이 눌릴때 실행할 코드
            })
            alert.setNegativeButton("취소",null)

            alert.show()
//
            return@setOnItemLongClickListener true



        }



    }
}