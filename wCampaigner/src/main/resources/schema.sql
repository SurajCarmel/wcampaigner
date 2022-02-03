CREATE TABLE wc_contact (
    ID varchar(40),
    fullname varchar(255),
    phoneOne varchar(10),
    phoneTwo varchar(10),
    phoneThree varchar(10),
    created_by varchar(40),
    creation_time datetime,
    deleted_by varchar(40),
    deleted_time datetime,
    is_deleted bit(1),
    last_modified_by varchar(40),
    last_modified_time datetime
);