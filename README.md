<a id="readme-top"></a>

<!-- HEADER -->
<div align="center">
  <h3 align="center">Eshop - Application Server</h3>
  <p align="center">
    RESTful application server for managing products, stock, and shopping carts.
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

This **Eshop** project is a RESTful application server that provides essential e-commerce functionality, allowing users to manage products, inventory, and shopping carts. It follows a structured API for the integration with external systems.

Built with Java and Spring Framework.

## Key Features

- **Product & Inventory Management**: Add, update, delete products and track stock levels.  
- **Shopping Cart System**: Create carts, add products (if in stock), and proceed to checkout.  
- **RESTful API**: A structured set of endpoints for managing the e-commerce workflow.  

### REST API Endpoints

| Method | Endpoint                   | Description                        |
|--------|----------------------------|------------------------------------|
| GET    | `/product`                 | Retrieve all products.            |
| POST   | `/product`                 | Create a new product.             |
| GET    | `/product/{id}`            | Retrieve details of a product.    |
| PUT    | `/product/{id}`            | Update an existing product.       |
| DELETE | `/product/{id}`            | Delete a product.                 |
| GET    | `/product/{id}/amount`     | Get stock quantity of a product.  |
| POST   | `/product/{id}/amount`     | Add stock for a product.          |
| POST   | `/cart`                    | Create a new shopping cart.       |
| GET    | `/cart/{id}`               | Get details of a shopping cart.   |
| DELETE | `/cart/{id}`               | Delete a shopping cart.           |
| POST   | `/cart/{id}/add`           | Add items to a shopping cart.     |
| GET    | `/cart/{id}/pay`           | Pay for the shopping cart.        |

### System Details

- **Stock Validation**: Prevents adding products to carts if stock is insufficient.
- **Error Handling**: Returns meaningful responses (e.g., `404 Not Found` for invalid IDs).  
- **Order Finalization**: Once a cart is paid, no further modifications can be made.  

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- TOOLS -->
### Built With

* [![Java][Java.com]][Java-url]
* [![Spring][Spring.com]][Spring-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LINKS -->
[Java.com]: https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/
[Spring.com]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/


### Created

2023
