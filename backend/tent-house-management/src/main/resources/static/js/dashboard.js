const CUSTOMER_API = "http://localhost:8080/api/customers";
const BOOKING_API = "http://localhost:8080/api/bookings";

loadCounts();

async function loadCounts() {
    try {
        const customers = await fetch(CUSTOMER_API)
            .then(res => res.json());

        document.getElementById("customerCount")
            .innerText = customers.length;

        const bookings = await fetch(BOOKING_API)
            .then(res => res.json());

        document.getElementById("bookingCount")
            .innerText = bookings.length;

    } catch (error) {
        console.error(error);
    }
}
