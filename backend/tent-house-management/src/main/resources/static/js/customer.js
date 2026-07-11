const API_URL = "/api/customers";

function showMessage(type, message) {

    const messageBox =
        document.getElementById("messageBox");

    messageBox.innerHTML = `
        <div class="alert alert-${type}">
            ${message}
        </div>
    `;

    setTimeout(() => {
        messageBox.innerHTML = "";
    }, 5000);
}

function toggleCustomerList() {

    const customerListCard =
        document.getElementById("customerListCard");

    const button =
        document.getElementById("toggleCustomerBtn");

    if (customerListCard.style.display === "none") {

        customerListCard.style.display = "block";
        button.innerText = "📋 Hide Customers";

        loadCustomers();

    } else {

        customerListCard.style.display = "none";
        button.innerText = "📋 View Customers";
    }
}

function renderCustomers(customers) {

    const tableBody =
        document.getElementById(
            "customerTableBody"
        );

    tableBody.innerHTML = "";

    customers.forEach(customer => {

        const row = `
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.name}</td>
                <td>${customer.mobileNumber}</td>
                <td>${customer.place}</td>
            </tr>
        `;

        tableBody.innerHTML += row;
    });
}

async function searchCustomers() {

    const name =
        document.getElementById("searchName")
            .value
            .trim();

    const mobile =
        document.getElementById("searchMobile")
            .value
            .trim();

    let url = API_URL;

    if (name !== "") {
        url =
            `${API_URL}/search/name?name=${encodeURIComponent(name)}`;
    }
    else if (mobile !== "") {
        url =
            `${API_URL}/search/mobile?mobileNumber=${encodeURIComponent(mobile)}`;
    }

    try {

        const response = await fetch(url);

        if (!response.ok) {

            const errorMessage =
                await response.text();

            showMessage(
                "warning",
                `Warning : ${errorMessage}`
            );

            return;
        }

        let customers = await response.json();

        if (!Array.isArray(customers)) {
            customers = [customers];
        }

        renderCustomers(customers);

        document.getElementById(
            "customerListCard"
        ).style.display = "block";

        document.getElementById(
            "toggleCustomerBtn"
        ).innerText =
            "📋 Hide Customers";

    }
    catch (error) {

        console.error(error);

        showMessage(
            "danger",
            "Unable to search customers."
        );
    }
}

function resetSearch() {

    document.getElementById(
        "searchName"
    ).value = "";

    document.getElementById(
        "searchMobile"
    ).value = "";

    if (
        document.getElementById(
            "customerListCard"
        ).style.display === "block"
    ) {
        loadCustomers();
    }
}

async function loadCustomers() {
    try {
        const response = await fetch(API_URL);
        const customers = await response.json();

        const tableBody =
            document.getElementById("customerTableBody");

        tableBody.innerHTML = "";

        customers.forEach(customer => {

            const row = `
                <tr>
                    <td>${customer.customerId}</td>
                    <td>${customer.name}</td>
                    <td>${customer.mobileNumber}</td>
                    <td>${customer.place}</td>
                </tr>
            `;

            tableBody.innerHTML += row;
        });

    } catch (error) {
        console.error(
            "Error loading customers:",
            error
        );
    }
}

async function saveCustomer(event) {
    event.preventDefault();

    const customer = {
        name: document.getElementById("name").value,
        mobileNumber:
        document.getElementById("mobileNumber").value,
        place:
        document.getElementById("place").value
    };

    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type":
                    "application/json"
            },
            body: JSON.stringify(customer)
        });

        if (!response.ok) {

            const errorMessage =
                await response.text();

            showMessage(
                "warning",
                `Warning : ${errorMessage}`
            );

            return;
        }

        document
            .getElementById("customerForm")
            .reset();

        if (
            document.getElementById(
                "customerListCard"
            ).style.display === "block"
        ) {
            loadCustomers();
        }

        showMessage(
            "success",
            "Customer saved successfully!"
        );

    } catch (error) {

        console.error(error);

        showMessage(
            "danger",
            "Unable to connect to server. Please try again."
        );
    }
}

document
    .getElementById("customerForm")
    .addEventListener(
        "submit",
        saveCustomer
    );
