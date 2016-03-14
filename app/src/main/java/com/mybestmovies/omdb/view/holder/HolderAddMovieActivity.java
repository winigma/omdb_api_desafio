package com.mybestmovies.omdb.view.holder;

import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.EditText;

import com.mybestmovies.omdb.mybestmovies.R;
import com.mybestmovies.omdb.view.interfaces.IListenersViews;

/**
 * Created by Wisley on 12/03/2016.
 */
public class HolderAddMovieActivity extends AbstractHolder {


    private EditText inputName;
    private TextInputLayout inputLayoutName;
    private Button btnSearch;

    public HolderAddMovieActivity(IListenersViews activityHomeView) {
        super(activityHomeView);
    }

    @Override
    protected void initializeFields() {

        this.inputName = (EditText) getField(R.id.input_name);
        this.inputLayoutName = (TextInputLayout) getField(R.id.input_layout_name);
        this.btnSearch = (Button) getField(R.id.btn_search);

    }

    public EditText getInputName() {
        return inputName;
    }

    public void setInputName(EditText inputName) {
        this.inputName = inputName;
    }

    public TextInputLayout getInputLayoutName() {
        return inputLayoutName;
    }

    public void setInputLayoutName(TextInputLayout inputLayoutName) {
        this.inputLayoutName = inputLayoutName;
    }

    public Button getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }
}
