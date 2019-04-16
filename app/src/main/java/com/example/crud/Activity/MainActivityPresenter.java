package com.example.crud.Activity;

public class MainActivityPresenter implements MainAcitivityContract.Presenter{
    private MainAcitivityContract.View view;

    public MainActivityPresenter(MainAcitivityContract.View view) {
        this.view = view;
    }

    @Override
    public void seeAllBiodata() {
        view.gotoListBiodata();

    }

    @Override
    public void addBiodata() {
        view.gotoaddBiodata();

    }
}
