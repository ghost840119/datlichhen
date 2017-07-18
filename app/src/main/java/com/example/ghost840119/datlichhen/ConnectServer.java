package com.example.ghost840119.datlichhen;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;


/**
 * Created by ghost840119 on 4/26/2017.
 */

public class ConnectServer {



    private Emitter.Listener onLogin = new Emitter.Listener(){
        @Override
        public void call(Object... args) {
            String message = args[0].toString();
            Log.d("Message : ",message);
        }
    };



}
