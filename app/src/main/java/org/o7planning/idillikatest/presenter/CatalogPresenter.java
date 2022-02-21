package org.o7planning.idillikatest.presenter;

import org.o7planning.idillikatest.Contract.CatalogListContract;
import org.o7planning.idillikatest.model.Constructor;
import org.o7planning.idillikatest.service.CatalogListModel;

import java.util.ArrayList;
import java.util.List;

public class CatalogPresenter implements CatalogListContract.Presenter, CatalogListContract.Model.onFinishedCall {

    private CatalogListContract.View catalogListView;
    private CatalogListContract.Model catalogListModel;

    public CatalogPresenter(CatalogListContract.View catalogListView) {
        this.catalogListView = catalogListView;
        catalogListModel = new CatalogListModel();
    }

    @Override
    public void onDestroy() {
        this.catalogListView = null;
    }

    @Override
    public void getMoreData(int pageNo) {
        if (catalogListView != null) {
            catalogListView.showLike();
        }
        catalogListModel.getConstructorList(this, pageNo);
    }

    @Override
    public void requestDataFromServer() {
        if (catalogListView != null) {
            catalogListView.showLike();
        }
        catalogListModel.getConstructorList(this, 1);
    }

    @Override
    public void onResponse(ArrayList<Constructor> catalogArrayList) {
        catalogListView.setDataToRecycleView(catalogArrayList);

        if (catalogListView != null) {
            catalogListView.hideLike();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        catalogListView.onResponseFailure(t);

        if (catalogListView != null) {
            catalogListView.hideLike();
        }
    }
}
