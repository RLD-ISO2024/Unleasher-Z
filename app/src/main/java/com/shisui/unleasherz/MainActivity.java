package com.shisui.unleasherz;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.appbar.MaterialToolbar;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener

{
    Selector abc = new Selector();
    private Spinner spinner1;
    public int we;
    private Spinner spinner;
    private Button unleasherz;
    private CheckBox rbpresets;
DrawerLayout draw;
NavigationView nav;
MaterialToolbar toolbar;

    private CheckBox rbcustom;

    private CheckBox rbimport;

    private CheckBox rbadd;
    private RadioButton h,i;

    private RelativeLayout scroll;

    private CheckBox c,d,e,f,g,j,k,l,m,n,o,p,q,r,w,y,z;

    private String zed;

    private String yes;
    public SharedPreferences sharedpreferences;
    public SharedPreferences.Editor xx;
    private int x;

    private int first;

    private RelativeLayout dialog;

    private RelativeLayout back;

    private TextView progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.presets);
        spinner1=(Spinner)findViewById(R.id.unleash);
        rbpresets = (CheckBox)findViewById(R.id.rbpresets);
        rbcustom = (CheckBox)findViewById(R.id.rbcustom);
        unleasherz = (Button)findViewById(R.id.unleasherss);
        unleasherz.setVisibility(View.GONE);
        draw=findViewById(R.id.drawerLayout);
        nav=findViewById(R.id.nav);
        toolbar=findViewById(R.id.appBar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,draw, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        draw.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        break;


                }
                return true;

            }
        });

        addListenerOnSpinnerItemSelection();


        first=0;

        c = (CheckBox)findViewById(R.id.c);
        d = (CheckBox)findViewById(R.id.d);
        e = (CheckBox)findViewById(R.id.e);
        f = (CheckBox)findViewById(R.id.f);
        g = (CheckBox)findViewById(R.id.g);
        h = (RadioButton)findViewById(R.id.h);
        i = (RadioButton)findViewById(R.id.i);
        j = (CheckBox)findViewById(R.id.j);

        l = (CheckBox)findViewById(R.id.l);
        m = (CheckBox)findViewById(R.id.m);
        n = (CheckBox)findViewById(R.id.n);
        o = (CheckBox)findViewById(R.id.o);
        p = (CheckBox)findViewById(R.id.p);
        q = (CheckBox)findViewById(R.id.q);
        r = (CheckBox)findViewById(R.id.r);
        w = (CheckBox)findViewById(R.id.w);
        y = (CheckBox)findViewById(R.id.y);
        z = (CheckBox)findViewById(R.id.z);
        k = (CheckBox)findViewById(R.id.k);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.presets,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        firstrun();
     states();

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        we=position;

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
    // Dito un
    public void presets(View v){
        if(rbpresets.isChecked()){
            spinner.setEnabled(true);
        }
        else{
            spinner.setEnabled(false);
        }
    }

    @Override
    public void onBackPressed() {
        if(draw.isDrawerOpen(GravityCompat.START)){
            draw.closeDrawer(GravityCompat.START);
        }
        else{
        super.onBackPressed();}
    }
public void alliance(){
    copyFileOrDir("unleasher");
    copyFileOrDir("ALLIANCE");
    try{
        Process su = Runtime.getRuntime().exec("su");
        DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());
        outputStream.writeBytes("chmod 755 /data/data/com.shisui.unleasherz/ALLIANCE\ncp -r /data/data/com.shisui.unleasherz/ALLIANCE /data/adb/modules/ALLIANCE\nchmod -r 755 /data/adb/modules/ALLIANCE\nchmod 755 /data/adb/modules/ALLIANCE\nchmod 755 /data/data/com.shisui.unleasherz/unleasher/unleasher.sh\ncp -r /data/data/com.shisui.unleasherz/unleasher/unleasher.sh /data/adb/service.d/unleasher.sh\nchmod 777 /data/adb/service.d/unleasher.sh\n");
        outputStream.flush();

        outputStream.writeBytes("exit\n");
        outputStream.flush();
        su.waitFor();
    }catch(IOException e){
        try {
            throw new Exception(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }catch(InterruptedException e){
        try {
            throw new Exception(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
    public void states(){
        if(rbpresets.isChecked()){
            spinner.setEnabled(true);
        }
        else{spinner.setEnabled(false);}
        if(rbcustom.isChecked()){
            c.setEnabled(true);
            d.setEnabled(true);
            e.setEnabled(true);
            f.setEnabled(true);
            g.setEnabled(true);
            h.setEnabled(true);
            i.setEnabled(true);
            j.setEnabled(true);
            k.setEnabled(true);
            l.setEnabled(true);
            m.setEnabled(true);
            n.setEnabled(true);
            o.setEnabled(true);
            p.setEnabled(true);
            q.setEnabled(true);
            r.setEnabled(true);
            w.setEnabled(true);
            y.setEnabled(true);
            z.setEnabled(true);
        }
        else{ c.setEnabled(false);
            d.setEnabled(false);
            e.setEnabled(false);
            f.setEnabled(false);
            g.setEnabled(false);
            h.setEnabled(false);
            i.setEnabled(false);
            j.setEnabled(false);
            k.setEnabled(false);
            l.setEnabled(false);
            m.setEnabled(false);
            n.setEnabled(false);
            o.setEnabled(false);
            p.setEnabled(false);
            q.setEnabled(false);
            r.setEnabled(false);
            w.setEnabled(false);
            y.setEnabled(false);
            z.setEnabled(false);}
}
    public void custom(View v){
        if(rbcustom.isChecked()){
            c.setEnabled(true);
            d.setEnabled(true);
            e.setEnabled(true);
            f.setEnabled(true);
            g.setEnabled(true);
            h.setEnabled(true);
            i.setEnabled(true);
            j.setEnabled(true);
            k.setEnabled(true);
            l.setEnabled(true);
            m.setEnabled(true);
            n.setEnabled(true);
            o.setEnabled(true);
            p.setEnabled(true);
            q.setEnabled(true);
            r.setEnabled(true);
            w.setEnabled(true);
            y.setEnabled(true);
            z.setEnabled(true);
        }
        else{
            c.setEnabled(false);
            d.setEnabled(false);
            e.setEnabled(false);
            f.setEnabled(false);
            g.setEnabled(false);
            h.setEnabled(false);
            i.setEnabled(false);
            j.setEnabled(false);
            k.setEnabled(false);
            l.setEnabled(false);
            m.setEnabled(false);
            n.setEnabled(false);
            o.setEnabled(false);
            p.setEnabled(false);
            q.setEnabled(false);
            r.setEnabled(false);
            w.setEnabled(false);
            y.setEnabled(false);
            z.setEnabled(false);
        }}

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.unleash);
        spinner1.setOnItemSelectedListener(new Selector());

        sharedpreferences = getSharedPreferences("Unleasher", Context.MODE_PRIVATE);
    }
    public void firstrun(){
        if(sharedpreferences.contains("firstrun")){
            unleasherz.setVisibility(View.VISIBLE);

            try {
                FileInputStream fileIn=openFileInput("memory.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(fileIn));
                String line = reader.readLine();
                while(line != null){
                    line = reader.readLine();
                    if (line.contains("custom")){
                        rbcustom.setChecked(true);
                    }
                    if (line.contains("presets")){

                        rbpresets.setChecked(true);
                       }
                        if (line.contains("power")){
                            spinner.setSelection(0);
                        }
                        if (line.contains("bal")){
                            spinner.setSelection(1);
                        }
                        if (line.contains("game")){
                            spinner.setSelection(2);
                        }
                        if (line.contains("perf")){
                            spinner.setSelection(3);
                        }
                        if (line.contains("ultra")){
                            spinner.setSelection(4);
                        }

                    if (line.contains("ml")){
                        spinner1.setSelection(0);
                    }
                    if (line.contains("cod")){
                        spinner1.setSelection(1);
                    }
                    if (line.contains("pubg")){
                        spinner1.setSelection(2);
                    }
                    if (line.contains("wild")){
                        spinner1.setSelection(3);
                    }
                    if (line.contains("asph")){
                        spinner1.setSelection(4);
                    }
                    if (line.contains("scroll")){
                        c.setChecked(true);
                    }
                    if (line.contains("ram")){
                        d.setChecked(true);
                    }
                    if (line.contains("signal")){
                        e.setChecked(true);
                    }
                    if (line.contains("cache")){
                        f.setChecked(true);
                    }
                    if (line.contains("net")){
                        g.setChecked(true);
                    }
                    if (line.contains("google")){
                        h.setChecked(true);
                    }
                    if (line.contains("cloud")){
                        i.setChecked(true);
                    }
                    if (line.contains("3G")){
                        j.setChecked(true);
                    }
                    if (line.contains("DL")){
                        k.setChecked(true);
                    }
                    if (line.contains("ipv4")){
                        l.setChecked(true);
                    }
                    if (line.contains("ipv6")){
                        m.setChecked(true);
                    }
                    if (line.contains("2D")){
                        n.setChecked(true);
                    }
                    if (line.contains("3D")){
                        o.setChecked(true);
                    }
                    if (line.contains("fling")){
                        p.setChecked(true);
                    }
                    if (line.contains("logging")){
                        q.setChecked(true);
                    }
                    if (line.contains("qcom")){
                        r.setChecked(true);
                    }
                    if (line.contains("fps")){
                        w.setChecked(true);
                    }
                    if (line.contains("render")){
                        y.setChecked(true);
                    }
                    if (line.contains("save")){
                        z.setChecked(true);
                    }



                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }




        else{
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this);
            builder.setTitle("WARNING!");
            builder.setIcon(R.drawable.warn);
            builder.setMessage("This app can break your device if used improperly. The Developer of the app is not responsible to any damages that this app may cause. Use this app wisely. :)");
            builder.setPositiveButton("AGREE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alliance();
                    try
                    { FileOutputStream fileout=openFileOutput(
                            "unleasher.txt"
                            , MODE_PRIVATE); OutputStreamWriter outputWriter=
                            new
                                    OutputStreamWriter(fileout);
                        outputWriter.write("Unleasher Z by Shisui08\n");
                        outputWriter.close();
                        unleasherz.setVisibility(View.VISIBLE);
                    }
                    catch
                    (Exception e) { e.printStackTrace(); }
                    xx=sharedpreferences.edit();
                    xx.putString("firstrun","1");
                    xx.commit();

                }
            });
            builder.setNegativeButton("DISAGREE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    unleasherz.setVisibility(View.GONE);


                }
            });
            builder.show();


        }}


    private void copyFileOrDir(String path) {
        AssetManager assetManager = this.getAssets();
        String assets[] = null;
        try {
            assets = assetManager.list(path);
            if (assets.length == 0) {
                copyFile(path);
            } else {
                String fullPath = "/data/data/" + this.getPackageName() + "/" + path;
                File dir = new File(fullPath);
                if (!dir.exists())
                    dir.mkdir();
                for (int i = 0; i < assets.length; ++i) {
                    copyFileOrDir(path + "/" + assets[i]);
                }
            }
        } catch (IOException ex) {
            Log.e("tag", "I/O Exception", ex);
        }
    }

    private void copyFile(String filename) {
        AssetManager assetManager = this.getAssets();

        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filename);
            String newFileName = "/data/data/" + this.getPackageName() + "/" + filename;
            out = new FileOutputStream(newFileName);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }

    }


    public void Final(View v){

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this);
        builder.setTitle("Confirmation");
        builder.setIcon(R.drawable.wait);
        builder.setMessage("Are you sure you want to Continue?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

        x = Selector.getData();
        try
        { FileOutputStream fileout=openFileOutput(
                "unleasher.txt"
                , MODE_PRIVATE); OutputStreamWriter outputWriter=
                new
                        OutputStreamWriter(fileout);
            outputWriter.write("Unleasher Z by Shisui08\n");

            try {
                FileOutputStream fileouts=openFileOutput("memory.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriters=new OutputStreamWriter(fileouts);
                outputWriters.write("Unleasher Z by Shisui08\n");



            if(rbpresets.isChecked()){
                if(we==4){outputWriter.append("ultra\n");outputWriters.append("ultra\n");}
                if(we==3){outputWriter.append("perf\n");outputWriters.append("perf\n");}
                if(we==2){outputWriter.append("game\n");outputWriters.append("game\n");}
                if(we==1){outputWriter.append("bal\n");outputWriters.append("bal\n");}
                if(we==0){outputWriter.append("power\n");outputWriters.append("power\n");
                }
                outputWriters.append("presets\n");
            }
            if(x==0){outputWriter.append("ml\n");outputWriters.append("ml\n");}
            if(x==1){outputWriter.append("cod\n");outputWriters.append("cod\n");}
            if(x==2){outputWriter.append("pubg\n");outputWriters.append("pubg\n");}
            if(x==3){outputWriter.append("wild\n");outputWriters.append("wild\n");}
            if(x==4){outputWriter.append("asph\n");outputWriters.append("asph\n");}
            if(rbcustom.isChecked()){
                outputWriters.append("custom\n");
                if(c.isChecked()){outputWriter.append("scroll\n");outputWriters.append("scroll\n");
                }
                if(d.isChecked()){outputWriter.append("ram\n");outputWriters.append("ram\n");
                }
                if(e.isChecked()){outputWriter.append("signal\n");outputWriters.append("signal\n");
                }
                if(f.isChecked()){outputWriter.append("cache\n");outputWriters.append("cache\n");
                }
                if(g.isChecked()){outputWriter.append("net\n");outputWriters.append("net\n");
                }
                if(h.isChecked()){outputWriter.append("google\n");outputWriters.append("google\n");
                }
                if(i.isChecked()){outputWriter.append("cloud\n");outputWriters.append("cloud\n");
                }
                if(j.isChecked()){outputWriter.append("3G\n");outputWriters.append("3G\n");
                }
                if(k.isChecked()){outputWriter.append("DL\n");outputWriters.append("DL\n");
                }
                if(l.isChecked()){outputWriter.append("ipv4\n");outputWriters.append("ipv4\n");
                }
                if(m.isChecked()){outputWriter.append("ipv6\n");outputWriters.append("ipv6\n");
                }
                if(n.isChecked()){outputWriter.append("2D\n");outputWriters.append("2D\n");
                }
                if(o.isChecked()){outputWriter.append("3D\n");outputWriters.append("3D\n");
                }
                if(p.isChecked()){outputWriter.append("fling\n");outputWriters.append("fling\n");
                }
                if(q.isChecked()){outputWriter.append("logging\n");outputWriters.append("logging\n");
                }
                if(r.isChecked()){outputWriter.append("qcom\n");outputWriters.append("qcom\n");
                }
                if(w.isChecked()){outputWriter.append("fps\n");outputWriters.append("fps\n");
                }
                if(y.isChecked()){outputWriter.append("render\n");outputWriters.append("render\n");
                }
                if(z.isChecked()){outputWriter.append("save\n");outputWriters.append("save\n");
                }


            }

            outputWriters.close();
            outputWriter.close();
                try{
                    Process su = Runtime.getRuntime().exec("su");
                    DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());
                    outputStream.writeBytes("chmod 660 /data/data/com.shisui.unleasherz/files/unleasher.txt\n" +
                            "chmod 644 /data/adb/modules/ALLIANCE/system.prop\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/a.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/b.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/c.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/d.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/e.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/f.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/g.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/h.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/i.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/j.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/k.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/l.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/m.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/n.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/o.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/p.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/q.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/r.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/s.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/t.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/u.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/v.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/w.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/x.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/y.txt\n" +
                            "chmod 644 /data/data/com.shisui.unleasherz/unleasher/z.txt\n"+
                            "echo \"# Unleasher Z by: Shisui08\" > /data/adb/modules/ALLIANCE/system.prop\n");
                    outputStream.flush();


                try {
                    FileInputStream fileIn=openFileInput("unleasher.txt");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(fileIn));
                    String line = reader.readLine();
                    while(line != null){

                        line = reader.readLine();
                        if (line.contains("ml")){
                        outputStream.writeBytes("a=$(cat /data/data/com.shisui.unleasherz/unleasher/a.txt)\n" +
                                "    echo \"$a\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("cod")){
                            outputStream.writeBytes("b=$(cat /data/data/com.shisui.unleasherz/unleasher/b.txt)\n" +
                                    "    echo \"$b\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("scroll")){
                            outputStream.writeBytes("c=$(cat /data/data/com.shisui.unleasherz/unleasher/c.txt)\n" +
                                    "    echo \"$c\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("ram")){
                            outputStream.writeBytes("d=$(cat /data/data/com.shisui.unleasherz/unleasher/d.txt)\n" +
                                    "    echo \"$d\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("signal")){
                            outputStream.writeBytes("e=$(cat /data/data/com.shisui.unleasherz/unleasher/e.txt)\n" +
                                    "    echo \"$e\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("cache")){
                            outputStream.writeBytes("f=$(cat /data/data/com.shisui.unleasherz/unleasher/f.txt)\n" +
                                    "    echo \"$f\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("net")){
                            outputStream.writeBytes("g=$(cat /data/data/com.shisui.unleasherz/unleasher/g.txt)\n" +
                                    "    echo \"$g\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("google")){
                            outputStream.writeBytes("h=$(cat /data/data/com.shisui.unleasherz/unleasher/h.txt)\n" +
                                    "    echo \"$h\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("cloud")){
                            outputStream.writeBytes("i=$(cat /data/data/com.shisui.unleasherz/unleasher/i.txt)\n" +
                                    "    echo \"$i\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("3G")){
                            outputStream.writeBytes("j=$(cat /data/data/com.shisui.unleasherz/unleasher/j.txt)\n" +
                                    "    echo \"$j\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("DL")){
                            outputStream.writeBytes("k=$(cat /data/data/com.shisui.unleasherz/unleasher/k.txt)\n" +
                                    "    echo \"$k\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("ipv4")){
                            outputStream.writeBytes("l=$(cat /data/data/com.shisui.unleasherz/unleasher/l.txt)\n" +
                                    "    echo \"$l\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("ipv6")){
                            outputStream.writeBytes("m=$(cat /data/data/com.shisui.unleasherz/unleasher/m.txt)\n" +
                                    "    echo \"$m\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("2D")){
                            outputStream.writeBytes("n=$(cat /data/data/com.shisui.unleasherz/unleasher/n.txt)\n" +
                                    "    echo \"$n\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("3D")){
                            outputStream.writeBytes("o=$(cat /data/data/com.shisui.unleasherz/unleasher/o.txt)\n" +
                                    "    echo \"$o\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("fling")){
                            outputStream.writeBytes("p=$(cat /data/data/com.shisui.unleasherz/unleasher/p.txt)\n" +
                                    "    echo \"$p\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("logging")){
                            outputStream.writeBytes("q=$(cat /data/data/com.shisui.unleasherz/unleasher/q.txt)\n" +
                                    "    echo \"$q\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("qcom")){
                            outputStream.writeBytes("r=$(cat /data/data/com.shisui.unleasherz/unleasher/r.txt)\n" +
                                    "    echo \"$r\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("ultra")){
                            outputStream.writeBytes("s=$(cat /data/data/com.shisui.unleasherz/unleasher/s.txt)\n" +
                                    "    echo \"$s\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("bal")){
                            outputStream.writeBytes("t=$(cat /data/data/com.shisui.unleasherz/unleasher/t.txt)\n" +
                                    "    echo \"$t\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("power")){
                            outputStream.writeBytes("u=$(cat /data/data/com.shisui.unleasherz/unleasher/u.txt)\n" +
                                    "    echo \"$u\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("perf")){
                            outputStream.writeBytes("v=$(cat /data/data/com.shisui.unleasherz/unleasher/v.txt)\n" +
                                    "    echo \"$v\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("fps")){
                            outputStream.writeBytes("w=$(cat /data/data/com.shisui.unleasherz/unleasher/w.txt)\n" +
                                    "    echo \"$w\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("game")){
                            outputStream.writeBytes("x=$(cat /data/data/com.shisui.unleasherz/unleasher/x.txt)\n" +
                                    "    echo \"$x\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("render")){
                            outputStream.writeBytes("y=$(cat /data/data/com.shisui.unleasherz/unleasher/y.txt)\n" +
                                    "    echo \"$y\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }
                        if (line.contains("save")){
                            outputStream.writeBytes("z=$(cat /data/data/com.shisui.unleasherz/unleasher/z.txt)\n" +
                                    "    echo \"$z\" >> /data/adb/modules/ALLIANCE/system.prop\n");
                        }



                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
                    outputStream.writeBytes("exit\n");
                    outputStream.flush();
                    su.waitFor();
                }catch(IOException e){
                    try {
                        throw new Exception(e);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }catch(InterruptedException e){
                    try {
                        throw new Exception(e);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this);
                    builder.setIcon(R.drawable.reboot);
                    builder.setTitle("PLEASE WAIT");
                    builder.setIcon(R.drawable.wait);
                    builder.setMessage("Unleashing... The Device will reboot automatically after "+millisUntilFinished/1000+" seconds.");
                    builder.show();



                }

                public void onFinish() {
                    SharedPreferences sharedpreferences = getSharedPreferences("Reboot", Context.MODE_PRIVATE);
                    SharedPreferences.Editor xx=sharedpreferences.edit();
                    xx.putInt("reboot",1);
                    xx.commit();
                    try{
                        Process su = Runtime.getRuntime().exec("su");
                        DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());
                        outputStream.writeBytes("su -c 'svc power reboot'\n");
                        outputStream.flush();

                        outputStream.writeBytes("exit\n");
                        outputStream.flush();
                        su.waitFor();
                    }catch(IOException e){
                        try {
                            throw new Exception(e);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }catch(InterruptedException e){
                        try {
                            throw new Exception(e);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                }

            }.start();


                //display file saved message

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch
        (Exception e) { e.printStackTrace(); } }




});
         builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {



    }
});
            builder.show();
    }}