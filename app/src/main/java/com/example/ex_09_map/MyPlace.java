package com.example.ex_09_map;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public class MyPlace {
    String title;
    LatLng latLng;
    double latitude, longitude;
    int color;

    // 현재 좌표는 초기화할때 가져올 수 없다. 좌표가 아직 없기 때문
    double [] arPos;

    MyPlace(String title, double latitude, double longitude, int color){
        this.title = title;
        this.latLng = new LatLng(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
        this.color = color;
    }

    // 배율
    double rate = 10;
    void setArPosition(Location currentLocation, float [] mePos){
        arPos = new double[]{
                mePos[0]+(currentLocation.getLongitude()-longitude)*rate, // 경도(x축)
                mePos[1]+(currentLocation.getLatitude()-latitude)*rate, // 위도(y축)
                mePos[2]*3 // 지도는 위도 경도만 준다.
        };
    }
}
