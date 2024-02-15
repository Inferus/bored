# Bored Shell

## Description

- Console application which gives you random or filtered activities.
- Uses [Bored API](https://www.boredapi.com/) for this purpose

## Technologies

- Java Spring
- Spring Shell

## Installation

### Requirements

- Java SDK 21
- OS

### Steps

1. Clone this repo
   ```
   git clone https://github.com/Inferus/bored
   ```
2. Enter bored folder
   ```
   cd bored
   ```
3. Make gradlew executable (MacOS, Linux)
   ```
   chmod 777 ./gradlew
   ```
4. Build the app using gradlew
   ```
   ./gradlew clean build
   ```

### How to run the Bored Shell (inside the project directory)

1. Run the `.jar` file
   ```
   java -jar build/libs/bored-0.0.1-SNAPSHOT.jar
   ```

## Usage

### Commands

1. `get-activity` - Without parameters gets a random activity

### Parameters

- `--type` - Gets an activity with a certain type (e.g. charity). Has autocomplition (use tabulation).
  Example:
  ```
  get-activity --type charity
  ```
- ` --key` - Find an activity by its key
- ` --participants` - Find a random activity with a given number of participants
- ` --price` - Find an activity with a specified price
- ` --accessibility` - Find a price in an inclusively constrained range
- ` --minaccessibility`, `--maxaccessibility` - Find an event with a specified accessibility in an inclusively constrained range
- ` --minprice`, `--maxprice` -Find an event with a specified price in an inclusively constrained range
