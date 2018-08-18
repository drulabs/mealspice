package com.talenitca.mealspiceandroid.screens.home;

import com.talenitca.mealspiceandroid.data.DataManager;
import com.talenitca.mealspiceandroid.data.models.Restaurant;
import com.talenitca.mealspiceandroid.data.network.retrofit.RestaurantService;
import com.talenitca.mealspiceandroid.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomePresenterTest {

    @Mock
    HomeContract.View view;

    @Mock
    RestaurantService restaurantService;

    @Mock
    DataManager dataManager;

    private HomePresenter presenter;

    @Before
    public void setUp() throws Exception {
        when(dataManager.fetchAllRestaurants(1)).thenReturn(
                Observable.just(TestUtils.getMockedRestaurantList()));
        presenter = new HomePresenter(view, dataManager, Schedulers.trampoline(), Schedulers.trampoline());

    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        presenter.destroy();
        assertNull(presenter.getView());
    }

    @Test
    public void checkIfRightViewIsShown() {
        presenter.fetchAllData();
        verify(view, times(1)).showLoading();
        verify(view, times(1)).hideLoading();
    }

    @Test
    public void checkIfCorrectListIsPassed() {
        ArgumentCaptor<List<Restaurant>> captor = forClass(List.class);
        presenter.fetchAllData();
        verify(view, times(1)).loadRestaurants(captor.capture());
        assertThat(captor.getValue(), is(TestUtils.getMockedRestaurantList()));
    }
}
