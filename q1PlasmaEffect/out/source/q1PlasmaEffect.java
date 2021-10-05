import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class q1PlasmaEffect extends PApplet {

//------------------------------------------------------------------
// 
// Assignment:  1
// Question:    1
// Student:     Kajal Tomar
//------------------------------------------------------------------

public void setup(){
    
    ortho(-1, 1, 1, -1);
    resetMatrix();
}

public void draw(){
    clear();

    drawPlasma(1.0f);    
}

public void drawPlasma(float time){
    float r,g,b;
    float v; 

    for(float x = -1; x <= 1; x+= 0.001f){
        for(float y = -1; y <= 1; y+= 0.001f){

            beginShape(POINTS);
                v = vertical(x,y,time) + diagonal(x,y,time) + cocentric(x,y,time);

                r = 1;
                g = cos(v*PI);
                b = sin(v*PI);

            
                stroke(r*255,g*255,b*255);
                vertex(x, y);
            endShape();
        }
    }
}

public float vertical(float x, float y, float time){
    float verticalV = sin(x*10+time);
    return verticalV;
}

public float diagonal(float x, float y, float time){
    float diagonalV = sin(10*(x*sin(time/2)+y*cos(time/3))+time);
    return diagonalV;
}

public float cocentric(float x, float y, float time){
    float cocentricV;
    float cx = x+.5f*sin(time/5);
    float cy = y + .5f*cos(time/3);

    cocentricV = sin(sqrt(275*(cx*cx+cy*cy)+1)+time);

    return cocentricV;
}
  public void settings() {  size(640,640,P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "q1PlasmaEffect" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
