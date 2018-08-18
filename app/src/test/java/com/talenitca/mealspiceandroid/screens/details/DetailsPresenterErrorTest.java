package com.talenitca.mealspiceandroid.screens.details;

import com.talenitca.mealspiceandroid.data.DataManager;
import com.talenitca.mealspiceandroid.data.network.retrofit.RestaurantService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DetailsPresenterErrorTest {

    @Mock
    DetailsContract.View view;

    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    DataManager dataManager;

    private DetailsPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new DetailsPresenter(view, dataManager);

    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        presenter.destroy();
        assertNull(presenter.getView());
    }

    @Test
    public void checkIfRightViewIsShown() {
        ArgumentCaptor<Throwable> captor = forClass(Throwable.class);
        presenter.start("anything");
        verify(view, times(1)).showLoading();
        verify(view, times(1)).hideLoading();
        verify(view, times(1)).onError(captor.capture());
    }

    @Test
    public void checkfICorrectErrorPassed() {
/*        ArgumentCaptor<String> captor2 = forClass(String.class);
        presenter.start("anything");
        verify(view, times(1)).loadRestaurantName(captor2.capture());
        assertThat(captor2.getValue(), is(TestUtils.getMockedRestaurant().getName()));*/

        ArgumentCaptor<Throwable> captor = forClass(Throwable.class);
        presenter.start("anything");
        verify(view, times(1)).onError(captor.capture());
        assertThat(captor.getValue().getMessage(), is("save me"));

    }
}
