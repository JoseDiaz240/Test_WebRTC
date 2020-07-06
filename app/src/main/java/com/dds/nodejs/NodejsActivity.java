package com.dds.nodejs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.dds.webrtc.R;
import com.dds.webrtclib.ws.JavaWebSocket;

public class NodejsActivity extends AppCompatActivity {
    private EditText et_signal;
    private EditText et_room;

    private EditText usuario_id;
    private Button button_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nodejs);
        initView();
        initVar();

    }

    private void initView() {
        et_signal = findViewById(R.id.et_signal);
        et_room = findViewById(R.id.et_room);

        usuario_id = findViewById(R.id.usuario_id);
        button_id = findViewById(R.id.button_id);
    }

    private void initVar() {
        et_signal.setText("http://52.149.214.3:8084/");
        et_room.setText("8084");

        button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JavaWebSocket.user_id = usuario_id.getText().toString();
            }
        });
    }

    /*-------------------- Prueba del servidor de versión Nodejs ---------------------------*/
    public void JoinRoomSingleVideo(View view) {
        WebrtcUtil.callSingle(this,
                et_signal.getText().toString(),
                et_room.getText().toString().trim(),
                true);
    }

    public void JoinRoom(View view) {
        WebrtcUtil.call(this, et_signal.getText().toString(), et_room.getText().toString().trim());

    }


}
