```sql
INSERT INTO r01_users (
    ID, Username, Password, Email, FirstName, LastName, DateOfBirth, Gender, Phone, Address, City, State, Country, Postal_Code, Created_At, Updated_At, Status, Role
) VALUES (
    '550e8400-e29b-41d4-a716-446655440000', -- UUID
    'johndoe', -- Username
    '$2y$12$wHjjAsDFG/sd3N7J6FTHz.RIEudkA9VNj5HDXYH/Z9sL7Y5xvVflW', -- Password (hashed)
    'johndoe@example.com', -- Email
    'John', -- FirstName
    'Doe', -- LastName
    '1990-01-01', -- DateOfBirth
    'Male', -- Gender
    '1234567890', -- Phone
    '123 Main St', -- Address
    'Anytown', -- City
    'Anystate', -- State
    'USA', -- Country
    '12345', -- Postal_Code
    CURRENT_TIMESTAMP, -- Created_At
    CURRENT_TIMESTAMP, -- Updated_At
    'active', -- Status
    'user' -- Role
);
```