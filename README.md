# Distributed Networks and Systems - Homework 1

## Description
This Java project implements a simple simulation of a postal system with parcels, mailboxes, a postman, and a recipient.

## Classes

### Parcel
- Represents a parcel with a unique integer identifier and a destination address.
- Provides methods to retrieve the address, make a copy of the parcel, and generate a textual description.

### Mailbox
- Represents a mailbox with an address and a capacity for storing parcels.
- Packet can be added individually to the mailbox.
- Provides methods to get the first parcel, get a parcel by recipient's address, and generate a textual description.

### ActivePerson
- Abstract class representing an active person with a name, time range limits, and an associated mailbox.
- Provides a method to generate a textual description.

### Postman
- Represents a postman who delivers parcels to various mailboxes.
- Maintains a list of mailboxes to deliver parcels.
- Provides a method to deliver parcels to respective addresses.

### Recipient
- Represents a recipient who retrieves parcels from a mailbox.
- Inherits from ActivePerson.
- Provides a method to retrieve parcels from the associated mailbox.

# Distributed Networks and Systems - Homework 2

## Description
This Java project extends the existing implementation with the addition of a new class called Reporter.
The existing classes include Warehouse, and active classes Producer and Consumer. The Reporter class is responsible for periodically displaying the content of a specified warehouse.

## Classes

### Warehouse
- Represents a warehouse that stores products.
- Provides methods for adding and removing products.

### Producer
- Represents a producer that produces products and adds them to the warehouse.

### Consumer
- Represents a consumer that consumes products from the warehouse.

### Reporter
- Represents a reporter responsible for periodically displaying the content of a specified warehouse.
- Generates a unique integer identifier automatically.
- Displays the content of the specified warehouse at regular time intervals.
