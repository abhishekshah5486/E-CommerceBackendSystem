### Class Design

### List of classes 

#### BaseModel
#### Category
#### Customer
#### Inventory
#### Orders
#### Product 

### List of ENUMs

#### ProductAvailability
#### OrderConfirmation
#### OrderStatus

### Base Model
### Category
  * Long id
  * String Title
  * String description

### Customer
  * Long id
  * String name
  * String email
  * LocalDate registrationDate
  * List<Long> orderIds

### Inventory
  * Long id
  * int stock
  * ProductAvailability productAvailability

### ENUM OrderConfirmation
  * PENDING
  * DECLINED
  * CANCELLED
  * CONFIRMED
    
### Orders
  * Long orderId
  * Long customerId
  * double totalAmount
  * LocalDate orderedDate
  * OrderStatus orderStatus
  * OrderConfirmation orderConfirmation
  * List<Long> productIds

### ENUM OrderStatus
  * PENDING
  * SHIPPED
  * DELIVERED

### Product
  * Long id
  * String title
  * String description
  * double price
  * double rating
  * Category category
  * Inventory inventory
  * ProductAvailability productAvailability

### ENUM ProductAvailability
  * OUT_OF_STOCK
  * AVAILABLE
  * IN_STOCK
  
