package com.example.nekit.wanted_vinyl;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Place implements Map<String, LatLng> {
    public static void main(String[] args){
        Map<String, LatLng> places = new TreeMap<>();
        places.put("http://sound-barrier.ru/Ru/Main.aspx", new LatLng(55.68708996, 37.54220366));
        places.put("https://newartstore.ru/", new LatLng(55.79363681,37.58409172));
        places.put("http://dig-store.ru/", new LatLng(55.7666426,37.66071707));
        places.put("https://www.respublica.ru/?gclid=CjwKCAjwlPTmBRBoEiwAHqpvhRpgGzLJE0Eukmmn3z1OFEZTx_EPcR5ZVydW_xzAzXyr47ODP35ENxoCl-AQAvD_BwE", new LatLng(55.82167614,37.49808133));
        places.put("https://www.respublica.ru/?gclid=CjwKCAjwlPTmBRBoEiwAHqpvhRpgGzLJE0Eukmmn3z1OFEZTx_EPcR5ZVydW_xzAzXyr47ODP35ENxoCl-AQAvD_BwE", new LatLng(55.75715835,37.65896641));
        places.put("https://www.respublica.ru/?gclid=CjwKCAjwlPTmBRBoEiwAHqpvhRpgGzLJE0Eukmmn3z1OFEZTx_EPcR5ZVydW_xzAzXyr47ODP35ENxoCl-AQAvD_BwE", new LatLng(55.77224329,37.59275526));
        places.put("https://www.respublica.ru/?gclid=CjwKCAjwlPTmBRBoEiwAHqpvhRpgGzLJE0Eukmmn3z1OFEZTx_EPcR5ZVydW_xzAzXyr47ODP35ENxoCl-AQAvD_BwE", new LatLng(55.75582518,37.61527508));
        places.put("https://www.respublica.ru/?gclid=CjwKCAjwlPTmBRBoEiwAHqpvhRpgGzLJE0Eukmmn3z1OFEZTx_EPcR5ZVydW_xzAzXyr47ODP35ENxoCl-AQAvD_BwE", new LatLng(55.7547552,37.62150111));
        places.put("https://www.respublica.ru/?gclid=CjwKCAjwlPTmBRBoEiwAHqpvhRpgGzLJE0Eukmmn3z1OFEZTx_EPcR5ZVydW_xzAzXyr47ODP35ENxoCl-AQAvD_BwE", new LatLng(55.66301161,37.48106539));
        places.put("https://www.respublica.ru/?gclid=CjwKCAjwlPTmBRBoEiwAHqpvhRpgGzLJE0Eukmmn3z1OFEZTx_EPcR5ZVydW_xzAzXyr47ODP35ENxoCl-AQAvD_BwE", new LatLng(55.79028919,37.53107786));
        places.put("https://www.respublica.ru/?gclid=CjwKCAjwlPTmBRBoEiwAHqpvhRpgGzLJE0Eukmmn3z1OFEZTx_EPcR5ZVydW_xzAzXyr47ODP35ENxoCl-AQAvD_BwE", new LatLng(55.75857509,37.64161706));
        places.put("https://vinyl.ru/", new LatLng(55.7492922,37.595982));
        places.put("https://transylvania.ru/", new LatLng(55.7607936,37.61127323));
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public LatLng get(Object key) {
        return null;
    }

    @Override
    public LatLng put(String key, LatLng value) {
        return null;
    }

    @Override
    public LatLng remove(Object key) {
        return null;
    }

    @Override
    public void putAll(@NonNull Map<? extends String, ? extends LatLng> m) {

    }

    @Override
    public void clear() {

    }

    @NonNull
    @Override
    public Set<String> keySet() {
        return null;
    }

    @NonNull
    @Override
    public Collection<LatLng> values() {
        return null;
    }

    @NonNull
    @Override
    public Set<Entry<String, LatLng>> entrySet() {
        return null;
    }
}
