package pe.edu.cibertec.maps;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        /*
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cibertecMiraflores, 20));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(cibertec));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 3000, null);
        */


        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLng cibertecMiraflores = new LatLng(-12.1222648, -77.0304797);
                mMap.addMarker(
                        new MarkerOptions()
                                .position(cibertecMiraflores)
                                .title("Cibertec")
                                .snippet("Sede Miraflores")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker)));

                LatLng cibertecSanIsidrio = new LatLng(-12.1041533, -77.0559932);
                mMap.addMarker(
                        new MarkerOptions()
                                .position(cibertecSanIsidrio)
                                .title("Cibertec")
                                .snippet("Sede San Isidro")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                LatLngBounds latLngBounds = new LatLngBounds.Builder()
                        .include(cibertecMiraflores)
                        .include(cibertecSanIsidrio)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 15));

                mMap.addPolyline(new PolylineOptions()
                        .add(cibertecMiraflores, cibertecSanIsidrio)
                        .width(5)
                        .color(Color.GREEN));

            }
        });
    }
}
