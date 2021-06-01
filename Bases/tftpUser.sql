USE [ProyectoRedes1]
GO

/****** Object:  Table [dbo].[User]    Script Date: 30/5/2021 1:48:58 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[tftpUser](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[passwordUser] [varchar](50) NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


/*Procedimiento almacenado Registrar*/

CREATE PROCEDURE Registrar   
    @username nvarchar(50),   
    @passwordUser nvarchar(50)  
AS   
BEGIN
    INSERT INTO tftpUser (username, passwordUser) values(@username,@passwordUser)    
END


/*Procedimiento almacenado Iniciar Sesion*/

CREATE PROCEDURE [dbo].[LoginUser]   
    @username nvarchar(50),   
    @passwordUser nvarchar(50),
    @result int OUTPUT
AS   
BEGIN
    IF EXISTS (SELECT username, passwordUser FROM tftpUser WHERE username = @username AND passwordUser = @passwordUser)
		BEGIN	
			SET @result = 1;
		END
	ELSE 
		BEGIN
			SET @result = 0;
		END
END
GO
