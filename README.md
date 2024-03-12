# Fake Store Carts API Custom Implementation

This is a simple custom implementation of the Fake Store Carts API.

# API Endpoints

### Get entire cart

```
GET /carts
```

### Get a single cart

```
GET /carts/{id}
```

### Get user carts

```
GET /carts/user/{id}
```

### Add a new cart

```
POST /carts
```

```
body: {
  userId: {userId},
  date: {date},
  products: [{productId: {id}, quantity: {quantity}}]
}
```

### Update a cart
```
PUT /carts/{id}
```

```
body: {
  userId: {userId},
  date: {date},
  products: [{productId: {id}, quantity: {quantity}}]
}
```

### Delete a cart

```
DELETE /carts/{id}
```