package com.talenitca.mealspiceandroid.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.talenitca.mealspiceandroid.data.models.Restaurant;

import java.lang.reflect.Type;
import java.util.List;

public class TestUtils {

    private static final String singleRestaurant = "{\n" +
            "  \"name\": \"Sun Dance Cafe\",\n" +
            "  \"email\": \"me@gmail.cm\",\n" +
            "  \"tagline\": \"Confluence of herbs, spices and tradition\",\n" +
            "  \"pic\": \"https://punefoodhunt.files.wordpress.com/2017/10/img_20171007_105450-e1509002011194.jpg\",\n" +
            "  \"cuisine\": \"Mexican, Japanese, Seafood\",\n" +
            "  \"address\": \"221B baker street, Paris\",\n" +
            "  \"latitude\": \"40.719269\",\n" +
            "  \"longitude\": \"-73.996846\",\n" +
            "  \"city\": \"Paris\",\n" +
            "  \"country\": \"France\",\n" +
            "  \"hasBranches\": true,\n" +
            "  \"updated\": \"18-Jan-2018\",\n" +
            "  \"established\": \"2011\",\n" +
            "  \"rating\": \"3\",\n" +
            "  \"comments\": [\n" +
            "    {\n" +
            "      \"restaurant_slug\": \"kombi-rocks-diner\",\n" +
            "      \"body\": \"exemplary vegan choices\",\n" +
            "      \"commented_by\": \"Dhruw\",\n" +
            "      \"date\": \"18-Jan-2018\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private static final String restaurantsJson = "[\n" +
            "  {\n" +
            "    \"updated\": \"2018-01-19T00:00:00.000Z\",\n" +
            "    \"established\": 2004,\n" +
            "    \"rating\": 3,\n" +
            "    \"comments\": [],\n" +
            "    \"_id\": \"5aa6433e36e38e0004409d86\",\n" +
            "    \"name\": \"Barbeque Village\",\n" +
            "    \"email\": \"contact@bbqvillage.com\",\n" +
            "    \"tagline\": \"Cook tight eat right\",\n" +
            "    \"pic\": \"https://b.zmtcdn.com/data/pictures/2/18591342/d04aed28b261ffaadd79311c4ccad573.jpg\",\n" +
            "    \"cuisine\": \"North Indian, Awadhi, BBQ\",\n" +
            "    \"address\": \"45, Sus -Parshan Bridge, Near Mahindra, Pune Mumbai -Bangalore Highway, Pashan, Pune\",\n" +
            "    \"city\": \"pune\",\n" +
            "    \"country\": \"India\",\n" +
            "    \"latitude\": \"18.5492644924\",\n" +
            "    \"longitude\": \"73.7723769620\",\n" +
            "    \"hasBranches\": false,\n" +
            "    \"slug\": \"barbeque-village\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"updated\": \"2017-10-06T00:00:00.000Z\",\n" +
            "    \"established\": 2012,\n" +
            "    \"rating\": 4,\n" +
            "    \"comments\": [],\n" +
            "    \"_id\": \"5aa6433e36e38e0004409d87\",\n" +
            "    \"name\": \"Rangla Punjab\",\n" +
            "    \"email\": \"contact@ranglapunjab.com\",\n" +
            "    \"tagline\": \"Carnival of spices and herbs\",\n" +
            "    \"pic\": \"https://b.zmtcdn.com/data/pictures/7/11817/c57e2e745b9267761980e59b2b122523.jpg\",\n" +
            "    \"cuisine\": \"Seafood, Biryani, North Indian, Chinese, Kebab\",\n" +
            "    \"address\": \"Near Kumar Papillon, Bangalore  Mumbai Highway, Off Sus Pashan Road, Pashan, Pune\",\n" +
            "    \"city\": \"pune\",\n" +
            "    \"country\": \"India\",\n" +
            "    \"latitude\": \"18.5425327484\",\n" +
            "    \"longitude\": \"73.7762252614\",\n" +
            "    \"hasBranches\": true,\n" +
            "    \"slug\": \"rangla-punjab\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"updated\": \"2018-02-19T00:00:00.000Z\",\n" +
            "    \"established\": 2017,\n" +
            "    \"rating\": 4,\n" +
            "    \"comments\": [],\n" +
            "    \"_id\": \"5aa6433e36e38e0004409d8f\",\n" +
            "    \"name\": \"Cabaret\",\n" +
            "    \"email\": \"cabaret@peterdonut.com\",\n" +
            "    \"tagline\": \"Dine, wine and, darts\",\n" +
            "    \"pic\": \"https://img1.nbstatic.in/la-webp-l/59c3b0dec9e77c000b1997cf.jpg\",\n" +
            "    \"cuisine\": \"Cafe, Asian, Steak, Korean, Salad, North Indian, Biryani\",\n" +
            "    \"address\": \"Ground floor, Aspirations, Baner Road, Baner, Pune\",\n" +
            "    \"city\": \"pune\",\n" +
            "    \"country\": \"India\",\n" +
            "    \"longitude\": \"18.5660205445\",\n" +
            "    \"latitude\": \"73.7728131562\",\n" +
            "    \"hasBranches\": false,\n" +
            "    \"slug\": \"cabaret\"\n" +
            "  }\n" +
            "]";

    private static final String restaurantsJSONBig = "[\n" +
            "    {\n" +
            "        \"name\": \"Lombardi's Pizza\",\n" +
            "        \"email\": \"lombardis@c2m.com\",\n" +
            "        \"tagline\": \"The paradise of spice blends\",\n" +
            "        \"pic\": \"https://b.zmtcdn.com/data/res_imagery/16771079_RESTAURANT_da60c9abb32fa64cddc148a2795ae43c_c.jpg\",\n" +
            "        \"cuisine\": \"Pizza, Italian\",\n" +
            "        \"address\": \"32 Spring Street, New York 10012\",\n" +
            "        \"city\": \"new-york-city\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"USA\",\n" +
            "        \"latitude\": \"40.7216750000\",\n" +
            "        \"longitude\": \"-73.9955888889\",\n" +
            "        \"hasBranches\": false,\n" +
            "        \"updated\": \"29-Jan-2018\",\n" +
            "        \"established\": 1913,\n" +
            "        \"rating\": 4,\n" +
            "        \"slug\": \"lombardis-pizza\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Café Habana\",\n" +
            "        \"email\": \"support@cafehabana.com\",\n" +
            "        \"tagline\": \"Donuts and Bagels - Round food for every mood\",\n" +
            "        \"pic\": \"https://b.zmtcdn.com/data/res_imagery/16761927_RESTAURANT_1e1f5ff368dae2c54f3cb2c34d490781_c.jpg\",\n" +
            "        \"cuisine\": \"Cuban, Mexican\",\n" +
            "        \"address\": \"17 Prince Street, New York 10012\",\n" +
            "        \"city\": \"new-york-city\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"USA\",\n" +
            "        \"latitude\": \"40.7229330000\",\n" +
            "        \"longitude\": \"-73.9941930000\",\n" +
            "        \"hasBranches\": true,\n" +
            "        \"updated\": \"12-feb-2018\",\n" +
            "        \"established\": 1988,\n" +
            "        \"rating\": 5,\n" +
            "        \"slug\": \"cafe-habana\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Barbeque Village\",\n" +
            "        \"email\": \"contact@bbqvillage.com\",\n" +
            "        \"tagline\": \"Cook tight eat right\",\n" +
            "        \"pic\": \"https://b.zmtcdn.com/data/pictures/2/18591342/d04aed28b261ffaadd79311c4ccad573.jpg\",\n" +
            "        \"cuisine\": \"North Indian, Awadhi, BBQ\",\n" +
            "        \"address\": \"45, Sus -Parshan Bridge, Near Mahindra, Pune Mumbai -Bangalore Highway, Pashan, Pune\",\n" +
            "        \"city\": \"pune\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"India\",\n" +
            "        \"latitude\": \"18.5492644924\",\n" +
            "        \"longitude\": \"73.7723769620\",\n" +
            "        \"hasBranches\": false,\n" +
            "        \"updated\": \"19-Jan-2018\",\n" +
            "        \"established\": 2004,\n" +
            "        \"rating\": 3,\n" +
            "        \"slug\": \"barbeque-village\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Rangla Punjab\",\n" +
            "        \"email\": \"contact@ranglapunjab.com\",\n" +
            "        \"tagline\": \"Carnival of spices and herbs\",\n" +
            "        \"pic\": \"https://b.zmtcdn.com/data/pictures/7/11817/c57e2e745b9267761980e59b2b122523.jpg\",\n" +
            "        \"cuisine\": \"Seafood, Biryani, North Indian, Chinese, Kebab\",\n" +
            "        \"address\": \"Near Kumar Papillon, Bangalore  Mumbai Highway, Off Sus Pashan Road, Pashan, Pune\",\n" +
            "        \"city\": \"pune\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"India\",\n" +
            "        \"latitude\": \"18.5425327484\",\n" +
            "        \"longitude\": \"73.7762252614\",\n" +
            "        \"hasBranches\": true,\n" +
            "        \"updated\": \"06-oct-2017\",\n" +
            "        \"established\": 2012,\n" +
            "        \"rating\": 4,\n" +
            "        \"slug\": \"rangla-punjab\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Ali's Trinidad Roti Shop\",\n" +
            "        \"email\": \"contact@AliRotiShop.com\",\n" +
            "        \"tagline\": \"Diversity served in a bread\",\n" +
            "        \"cuisine\": \"Caribbean\",\n" +
            "        \"address\": \"1267 Fulton Street, Brooklyn 11216\",\n" +
            "        \"city\": \"brooklyn\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"USA\",\n" +
            "        \"latitude\": \"40.6803888889\",\n" +
            "        \"longitude\": \"-73.9506305556\",\n" +
            "        \"hasBranches\": false,\n" +
            "        \"updated\": \"21-Jan-2018\",\n" +
            "        \"established\": 1990,\n" +
            "        \"rating\": 5,\n" +
            "        \"slug\": \"alis-trinidad-roti-shop\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Halsey Street Grill\",\n" +
            "        \"email\": \"contact@halseygrill.com\",\n" +
            "        \"tagline\": \"Breakfast of chapmpions\",\n" +
            "        \"pic\": \"http://1.bp.blogspot.com/-GS7Op8w_bBI/UjL-YymiFwI/AAAAAAAAK_w/P_1kUhX3O0U/s1600/IMG_1900.JPG\",\n" +
            "        \"cuisine\": \"Seafood, Southern\",\n" +
            "        \"address\": \"260 Halsey Street, New York 11216\",\n" +
            "        \"city\": \"brooklyn\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"USA\",\n" +
            "        \"latitude\": \"40.6824150000\",\n" +
            "        \"longitude\": \"-73.9432220000\",\n" +
            "        \"hasBranches\": true,\n" +
            "        \"updated\": \"26-nov-2017\",\n" +
            "        \"established\": 2003,\n" +
            "        \"rating\": 4,\n" +
            "        \"slug\": \"halsey-street-grill\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Palette 22\",\n" +
            "        \"email\": \"contact@Apalette22.com\",\n" +
            "        \"tagline\": \"Pure, pulpable, palatable, palette\",\n" +
            "        \"pic\": \"http://dconheels.com/wp-content/uploads/2016/02/outside-resize.jpg\",\n" +
            "        \"cuisine\": \"American\",\n" +
            "        \"address\": \"4053 Campbell Avenue 22206\",\n" +
            "        \"city\": \"arlington-county\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"USA\",\n" +
            "        \"latitude\": \"38.8411560000\",\n" +
            "        \"longitude\": \"-77.0885110000\",\n" +
            "        \"hasBranches\": false,\n" +
            "        \"updated\": \"13-May-2017\",\n" +
            "        \"established\": 1986,\n" +
            "        \"rating\": 5,\n" +
            "        \"slug\": \"palette-22\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Atlantis Pizzeria\",\n" +
            "        \"email\": \"contact@AtlantisPizzeria.com\",\n" +
            "        \"tagline\": \"world tour in minutes\",\n" +
            "        \"pic\": \"http://1.bp.blogspot.com/-GS7Op8w_bBI/UjL-YymiFwI/AAAAAAAAK_w/P_1kUhX3O0U/s1600/IMG_1900.JPG\",\n" +
            "        \"cuisine\": \"Greek, Italian, Pizza\",\n" +
            "        \"address\": \"23648 King Street, Alexandria 22302\",\n" +
            "        \"city\": \"alexandria\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"USA\",\n" +
            "        \"latitude\": \"38.8294260000\",\n" +
            "        \"longitude\": \"-77.0913830000\",\n" +
            "        \"hasBranches\": true,\n" +
            "        \"updated\": \"22-feb-2018\",\n" +
            "        \"established\": 2013,\n" +
            "        \"rating\": 4,\n" +
            "        \"slug\": \"atlantis-pizzeria\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Kombi Rocks Diner\",\n" +
            "        \"email\": \"contact@KombiRocks.com\",\n" +
            "        \"tagline\": \"Sea food with a distinction\",\n" +
            "        \"pic\": \"https://www.shinyvisa.com/wp-content/uploads/2016/09/kombi-rocks-main-810x613.jpg\",\n" +
            "        \"cuisine\": \"Chinese, Seafood, Thai\",\n" +
            "        \"address\": \"Yio Chu Kang Road, #66, Serangoon 545568\",\n" +
            "        \"city\": \"singapore\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"Singapore\",\n" +
            "        \"latitude\": \"1.3574723027\",\n" +
            "        \"longitude\": \"103.8755176160\",\n" +
            "        \"hasBranches\": false,\n" +
            "        \"updated\": \"13-sept-2017\",\n" +
            "        \"established\": 2007,\n" +
            "        \"rating\": 5,\n" +
            "        \"slug\": \"kombi-rocks-diner\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"The Coffee Daily\",\n" +
            "        \"email\": \"contact@CoffeeDaily.com\",\n" +
            "        \"tagline\": \"Affordable luxary dining\",\n" +
            "        \"pic\": \"http://1.bp.blogspot.com/-GS7Op8w_bBI/UjL-YymiFwI/AAAAAAAAK_w/P_1kUhX3O0U/s1600/IMG_1900.JPG\",\n" +
            "        \"cuisine\": \"Greek, Italian, Pizza\",\n" +
            "        \"address\": \"75 Brighton Crescent, Serangoon Garden Estate 559216\",\n" +
            "        \"city\": \"singapore\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"Singapore\",\n" +
            "        \"latitude\": \"1.3629670637\",\n" +
            "        \"longitude\": \"103.8712271610\",\n" +
            "        \"hasBranches\": true,\n" +
            "        \"updated\": \"28-feb-2018\",\n" +
            "        \"established\": 2015,\n" +
            "        \"rating\": 4,\n" +
            "        \"slug\": \"the-coffee-daily\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Graze Kitchen\",\n" +
            "        \"email\": \"contact@GrazeKitchen.com\",\n" +
            "        \"tagline\": \"Fusion of cultures and traditions\",\n" +
            "        \"pic\": \"https://d3dz4rogqkqh6r.cloudfront.net/uploads/files/2016/11/yimg_KXQ1s2-640x427.jpg\",\n" +
            "        \"cuisine\": \"Sri Lankan, Indian, Japanese, Chinese\",\n" +
            "        \"address\": \"Hilton Colombo, 2, Sir Chittampalam A Gardiner Mawatha, Fort, Colombo 01\",\n" +
            "        \"city\": \"colombo\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"Sri Lanka\",\n" +
            "        \"latitude\": \"6.9319055556\",\n" +
            "        \"longitude\": \"79.8448944444\",\n" +
            "        \"hasBranches\": true,\n" +
            "        \"updated\": \"28-feb-2018\",\n" +
            "        \"established\": 2010,\n" +
            "        \"rating\": 4,\n" +
            "        \"slug\": \"graze-kitchen\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cabaret\",\n" +
            "        \"email\": \"cabaret@peterdonut.com\",\n" +
            "        \"tagline\": \"Dine, wine and, darts\",\n" +
            "        \"pic\": \"https://img1.nbstatic.in/la-webp-l/59c3b0dec9e77c000b1997cf.jpg\",\n" +
            "        \"cuisine\": \"Cafe, Asian, Steak, Korean, Salad, North Indian, Biryani\",\n" +
            "        \"address\": \"Ground floor, Aspirations, Baner Road, Baner, Pune\",\n" +
            "        \"city\": \"pune\",\n" +
            "        \"comments\": [],\n" +
            "        \"country\": \"India\",\n" +
            "        \"longitude\": \"18.5660205445\",\n" +
            "        \"latitude\": \"73.7728131562\",\n" +
            "        \"hasBranches\": false,\n" +
            "        \"updated\": \"19-Feb-2018\",\n" +
            "        \"established\": 2017,\n" +
            "        \"rating\": 4,\n" +
            "        \"slug\": \"cabaret\"\n" +
            "      }\n" +
            "]";

    public static List<Restaurant> getMockedRestaurantList() {
        Gson gson = new Gson();
        Type restaurantListType = new TypeToken<List<Restaurant>>() {
        }.getType();
        return gson.fromJson(restaurantsJson, restaurantListType);
    }

    public static List<Restaurant> getMockedRestaurantListBIG() {
        Gson gson = new Gson();
        Type restaurantListType = new TypeToken<List<Restaurant>>() {
        }.getType();
        return gson.fromJson(restaurantsJSONBig, restaurantListType);
    }

    public static Restaurant getMockedRestaurant() {
        Gson gson = new Gson();
        return gson.fromJson(singleRestaurant, Restaurant.class);
    }

}
