public class Expedia {
    public static void main(String[] args){
        SearchFlightForm search = new SearchFlightForm();

        search.verifyPage();

        search.waitForFlightElement();

        search.clickFlights();

        search.enterOrigin();
        search.enterDest();
        search.departureDate();
        search.arrivalDate();
        FlightListPage flights = search.submitSearch();

        flights.waitForFlightList();
        flights.verifyFlightsExist();


    }
}
