# Clinic Management System

A comprehensive, bilingual (French/English) Java console application designed to manage hospital operations, track patients, and calculate billing. 

## Key Features
- **Patient Management:** Admit and discharge both Inpatients and Outpatients.
- **Data Persistence:** Automatically saves and loads patient data to/from a local `patients.txt` file so data isn't lost between sessions.
- **Billing Engine:** Dynamically calculates total hospital revenue and individual patient bills based on admission days or consultation fees.
- **Fast Search:** Uses a `HashMap` for O(1) patient lookups by ID.

## What I Practiced
- **Advanced OOP:** Used inheritance (e.g., `Inpatient` and `Outpatient` classes extending a base `Patient` class) and method overriding.
- **Data Structures:** Managed data using both `ArrayList` (for ordered iteration) and `HashMap` (for fast retrieval).
- **File I/O:** Implemented reading and writing to text files using `BufferedReader`, `FileWriter`, and `PrintWriter`.
- **Robustness:** Added `try-catch` blocks to handle invalid user inputs and file reading errors.

## Project Structure
- `Clinic.java`: The main entry point containing the user interface and menu loop.
- `Management.java`: The controller class handling data logic, `ArrayList`, `HashMap`, and File I/O.
- `Patient.java`: The abstract base class defining the core patient structure.
- `Inpatient.java` & `Outpatient.java`: Subclasses handling specific billing logic and data for different patient types.

## Tech Stack
- Java (Console-based)
