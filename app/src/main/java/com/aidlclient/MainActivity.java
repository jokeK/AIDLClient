package com.aidlclient;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import com.aidlservice.IPerson;
import com.aidlservice.MyBank.Bank;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private IPerson person;
//    ServiceConnection conn = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            Toast.makeText(MainActivity.this,"连接成功",Toast.LENGTH_SHORT).show();
//            person= IPerson.Stub.asInterface(service);
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BankManager.getIntence().connectService(this);
        Button button = findViewById(R.id.button);
//        Intent intent = new Intent("ServiceAidl");
//        intent.setPackage("com.aidlservier");
//        //intent.setAction("ServiceAidl");
//        bindService(intent,conn, Service.BIND_AUTO_CREATE);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (person!=null){
//                    try {
//                       String name = person.getValue();
//                        Toast.makeText(MainActivity.this,"进程调用成功:"+name,Toast.LENGTH_SHORT).show();
//                    } catch (RemoteException e) {
//                        e.printStackTrace();
//                        Toast.makeText(MainActivity.this,"进程调用失败:"+e.toString(),Toast.LENGTH_SHORT).show();
//                    }
//                }else {
//                    Toast.makeText(MainActivity.this,"person为null",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<Bank> banks = BankManager.getIntence().getIBankManager().getBanks();
                    if (banks.size()>0){
                        String name = banks.get(0).getName();
                        Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
                    }

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BankManager.getIntence().unBinderService(MainActivity.this);
    }
}
