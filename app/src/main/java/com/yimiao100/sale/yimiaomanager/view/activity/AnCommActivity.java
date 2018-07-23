package com.yimiao100.sale.yimiaomanager.view.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yimiao100.sale.yimiaomanager.R;

public class AnCommActivity extends Activity implements View.OnClickListener {

    private TextView text1, text2;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_an_comm);
        mContext = this;
        initView();

    }

    private void initView() {
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text1:
                dialogShow1();
                break;
            case R.id.text2:
                dialogShow2();
                break;

            default:
                break;
        }
    }

    private void dialogShow1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("温馨提示");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("原理是基本");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(mContext, "no", 1).show();
            }
        });
        builder.setPositiveButton("立即更新",
                new DialogInterface.OnClickListener() {

                    @SuppressLint("WrongConstant")
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(mContext, "ok", 1).show();
                    }
                });
        Dialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 自定义布局
     * setView()只会覆盖AlertDialog的Title与Button之间的那部分，而setContentView()则会覆盖全部，
     * setContentView()必须放在show()的后面
     */
    private void dialogShow2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.up, null);
        TextView content = (TextView) v.findViewById(R.id.dialog_content);
        Button btn_cancel = (Button) v.findViewById(R.id.dialog_btn_cancel);
        //builer.setView(v);//这里如果使用builer.setView(v)，自定义布局只会覆盖title和button之间的那部分
        final Dialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后面
        //dialog.getWindow().setGravity(Gravity.CENTER);//可以设置显示的位置

        btn_cancel.setOnClickListener(new View.OnClickListener() {

            @SuppressLint({"WrongConstant", "ShowToast"})
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
                Toast.makeText(mContext, "no", 1).show();
            }
        });
    }

}
