package com.neppplus.listview_20211120.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.listview_20211120.R
import com.neppplus.listview_20211120.datas.StudentData

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StudentData>) : ArrayAdapter<StudentData>(mContext, resId, mList) {

//    Adapter 역할 : xml + 데이터클래스 자료 조합.

//    xml파일을 -> 이 Adapter 코드에서 끌어다 사용하게 도와줌. (도구)
    val mInflater =  LayoutInflater.from(mContext)

//    xml + 데이터 조합 -> 위치에 뿌려주는 함수 (ArrayAdapter 제공) -> 커스터마이징 (함수 오버라이딩)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null) {

            tempRow =  mInflater.inflate(R.layout.student_list_item, null)

        }
//        xml= row변수에 담아주자

        val row = tempRow!!
//        데이터 가공
        
//        근거데이터를 가져오자
        val data = mList[position]
        
//        뿌려진 ui들을 가져오자, row 내부에서 찾아오자
        
        val txtStudentName = row.findViewById<TextView>(R.id.txtStudentName)
        val txtAge = row.findViewById<TextView>(R.id.txtAge)
        val txtAddress = row.findViewById<TextView>(R.id.txtAddress)

        
//        ui에 데이터를 필요한 변수 추출 반영
        txtStudentName.text = data.name
//        txtAge.text = "${data.birthYear} 년생"
//        (34세 등으로 나이를 계산.가공)
        val age = 2021 - data.birthYear + 1
        txtAge.text = "(${age}세)"
        txtAddress.text = data.address

//        row에 담긴xml 화면에 뿌려주게 내보내주자

        return row
    }


}