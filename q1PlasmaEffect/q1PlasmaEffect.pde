//------------------------------------------------------------------
// Assignment:  1
// Question:    1
// Student:     Kajal Tomar
//------------------------------------------------------------------

void drawPlasma(float time){
    float r,g,b;
    float v; 

    // go through the whole screen
    for(float x = -1; x <= 1; x+= 0.001){
        for(float y = -1; y <= 1; y+= 0.001){

            // fill in points accodring to the cobination of algorithm
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

float vertical(float x, float y, float time){
    float verticalV = sin(x*10+time);
    return verticalV;
}

float diagonal(float x, float y, float time){
    float diagonalV = sin(10*(x*sin(time/2)+y*cos(time/3))+time);
    return diagonalV;
}

float cocentric(float x, float y, float time){
    float cocentricV;
    float cx = x+.5*sin(time/5);
    float cy = y + .5*cos(time/3);

    cocentricV = sin(sqrt(275*(cx*cx+cy*cy)+1)+time);

    return cocentricV;
}

void setup(){
    size(640,640,P3D);
    ortho(-1, 1, 1, -1);
    resetMatrix();
}

void draw(){
    clear();
    drawPlasma(1.0);    
}