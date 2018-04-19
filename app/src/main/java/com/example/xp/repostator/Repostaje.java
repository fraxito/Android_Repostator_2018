package com.example.xp.repostator;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Repostaje extends Fragment {


    public Repostaje() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repostaje, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        final EditText editPrecio = (EditText) getActivity().findViewById(R.id.precio);
        editPrecio.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if(i == EditorInfo.IME_ACTION_DONE){
                    SharedPreferences sp =
                            getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    int size = sp.getInt("Listado_size", 0);
                    size++;
                    editor.putString("Repostaje_" + size, editPrecio.getText().toString());
                    editor.putInt("Listado_size", size);
                    editor.commit();
                    Toast.makeText(getActivity(), editPrecio.getText().toString(), Toast.LENGTH_LONG).show();

                    getActivity().finish();

                }

                return false;
            }
        });
    }
}
