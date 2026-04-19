Dynamic Notification Module

This is a simple full-stack application built as part of the TEHIK Engineering Challenge.
The system allows administrators to manage system-wide notifications dynamically, while end users can view the current system status in real time.

🧩 Overview

The application consists of:

    Backend: Java 25 + Spring Boot 4
    Frontend: Angular
    Database: H2 (in-memory)
    Authentication: Basic Authentication for admin endpoints
    Public API: Open for all users (no login required)

🎯 Business Requirements

The system implements the following features:

    1. Notification Management (Admin)
    Admin can create a notification with:
    Title
    Content
    Active / inactive state
    Only one notification is considered active at a time.
    Admin can:
    Create
    Update
    Delete
    Activate / deactivate notifications

    2. Public API (User View)

    The public endpoint returns:

    Notification title and content (if active)
    Current server timestamp
    Support contact information (fixed in backend)

    If no active notification exists:

    The API returns a status indicating the system is operational

    3. Authentication & Security
    /api/admin/** → protected with Basic Authentication
    /api/notification → public access (no login required)

    Default admin credentials:

    username: admin
    password: admin123

    4. Frontend Views
    The Angular application has two views:

    Admin View (/admin)

    Protected with Basic Auth
    Allows managing notifications
    Calls secured backend endpoints

    User View (/)

    Public page
    Displays:
    Active notification OR
    “System operational” message
    Shows formatted server timestamp

🧪 Example API Response

    Active notification:
    {
    "title": "MAINTENANCE",
    "content": "18:00-22:00",
    "timestamp": "2026-04-19T19:52:29",
    "supportContact": "support@tehik.ee",
    "active": true
    }
    No active notification:
    {
    "status": "OK",
    "message": "System is operational",
    "timestamp": "2026-04-19T19:52:29",
    "supportContact": "support@tehik.ee"
    }

Simple step-by-step usage:

    1. Start backend:
    - Open terminal in backend folder
    - Run: ./gradlew bootRun
    - Backend runs at http://localhost:8080

    2. Start frontend:
    - Open terminal in frontend folder
    - Run: npm install
    - Run: ng serve
    - Open http://localhost:4200 in browser

    3. Use application:
    - User view: open http://localhost:4200
    - Admin view: open http://localhost:4200/admin

    4. Admin login:
    - username: admin
    - password: admin123


🛠 Tech Notes
    Angular uses HttpClient for API communication
    Backend uses Spring Security with Basic Auth
    CORS is enabled for localhost development
    Data is stored in H2 in-memory database

📌 Notes
    This project is intentionally simple and focused on business logic clarity
    UI design is minimal and not a focus of the solution
    The goal is maintainability and clean separation between admin and public views

👨‍💻 Author
    Allan Saariste with help of ChatGPT.