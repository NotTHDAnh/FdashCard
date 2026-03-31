CREATE DATABASE FdashCard;
GO

USE FdashCard;
GO

CREATE TABLE dbo.tblCardSet (
    id INT NOT NULL,
    description NVARCHAR(500) NOT NULL,
    name NVARCHAR(500) NOT NULL,
    status BIT NOT NULL CONSTRAINT DF_tblCardSet_status DEFAULT ((1)),
    CONSTRAINT PK_tblCardSet PRIMARY KEY (id)
);
GO

CREATE TABLE dbo.tblCards (
    id INT NOT NULL,
    hint NVARCHAR(300) NOT NULL,
    description NVARCHAR(300) NOT NULL,
    set_id INT NOT NULL,
    CONSTRAINT PK_tblCards PRIMARY KEY (id, set_id),
    CONSTRAINT FK_tblCards_tblCardSet FOREIGN KEY (set_id)
        REFERENCES dbo.tblCardSet(id)
);
GO
