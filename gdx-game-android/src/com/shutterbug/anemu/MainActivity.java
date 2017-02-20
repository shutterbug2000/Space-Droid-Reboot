package com.shutterbug.anemu;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import android.content.*;
import com.shutterbug.anemu.cpucomponents.*;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
		gdxToast.context = getApplicationContext();
		
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        
        initialize(new MyGdxGame(), cfg);
    }
	
	//private static Context context;

    //public static Context getAppContext() {
    //    return MainActivity.context;
	//}
	
}
