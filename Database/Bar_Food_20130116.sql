use master
GO

IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'BAR_Food')
DROP DATABASE [BAR_Food]
GO

CREATE DATABASE [BAR_Food]
GO

USE [BAR_Food]
GO
/****** Object:  Table [dbo].[BAR_Comment]    Script Date: 16/01/2013 9:03:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_Comment](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RestaurantId] [int] NOT NULL,
	[UserId] [int] NOT NULL,
	[Comment] [nvarchar](250) NULL,
	[Rating] [int] NULL,
	[Timestamp] [datetime] NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_BAR_Comment] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BAR_Discount]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_Discount](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RestaunrantId] [int] NULL,
	[Value] [int] NULL,
	[BeginDate] [datetime] NULL,
	[EndDate] [datetime] NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_BAR_Discount] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BAR_Dish]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_Dish](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RestaurantId] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](50) NULL,
	[Price] [money] NULL,
	[CategoryId] [int] NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_BAR_Menu] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BAR_DishCategory]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_DishCategory](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RestaurantId] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_BAR_MenuCategory] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BAR_Location]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_Location](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[LocationName] [nvarchar](50) NULL,
	[LocationLevel] [int] NULL,
	[ParentId] [int] NULL,
 CONSTRAINT [PK_BAR_Location] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BAR_LocationFilter]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_LocationFilter](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RestaurantId] [int] NULL,
	[LocationId] [int] NULL,
	[isDeliverable] [bit] NULL,
	[DeliveryFee] [money] NULL,
 CONSTRAINT [PK_BAR_LocationFilter] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BAR_Order]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_Order](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NULL,
	[RestaurantId] [int] NOT NULL,
	[VourcherId] [int] NULL,
	[Date] [datetime] NOT NULL,
 CONSTRAINT [PK_BAR_Order] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BAR_OrderDetails]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_OrderDetails](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NULL,
	[DishId] [int] NULL,
	[Quantity] [int] NULL,
	[Price] [money] NULL,
	[TotalPrice] [money] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BAR_Restaurant]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BAR_Restaurant](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Latitute] [decimal](18, 0) NULL,
	[Longtitue] [decimal](18, 0) NULL,
	[Address] [nvarchar](100) NULL,
	[Description] [nvarchar](250) NULL,
	[PhoneNum] [varchar](20) NULL,
	[MinimumOrder] [money] NULL,
	[OpenHours] [datetime] NULL,
	[CloseHours] [datetime] NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_BAR_Restaurant] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BAR_Roles]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BAR_Roles](
	[Id] [int] NOT NULL,
	[Roles] [varchar](20) NULL,
 CONSTRAINT [PK_BAR_Roles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BAR_UserDetails]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BAR_UserDetails](
	[Id] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Lastname] [nvarchar](50) NULL,
	[Email] [varchar](100) NULL,
	[Province] [nvarchar](50) NOT NULL,
	[District] [nvarchar](50) NULL,
	[Ward] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NULL,
	[AccommodationType] [nvarchar](50) NULL,
	[PhoneNum] [varchar](20) NULL,
 CONSTRAINT [PK_BAR_UserDetails] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BAR_Users]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BAR_Users](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[RoleId] [int] NULL,
	[isActive] [bit] NOT NULL,
 CONSTRAINT [PK_BAR_Users] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BAR_VoucherCode]    Script Date: 16/01/2013 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BAR_VoucherCode](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Code] [varchar](10) NULL,
	[isActive] [bit] NULL,
 CONSTRAINT [PK_BAR_VoucherCode] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[BAR_Comment]  WITH CHECK ADD  CONSTRAINT [FK_BAR_Comment_BAR_Restaurant] FOREIGN KEY([RestaurantId])
REFERENCES [dbo].[BAR_Restaurant] ([Id])
GO
ALTER TABLE [dbo].[BAR_Comment] CHECK CONSTRAINT [FK_BAR_Comment_BAR_Restaurant]
GO
ALTER TABLE [dbo].[BAR_Comment]  WITH CHECK ADD  CONSTRAINT [FK_BAR_Comment_BAR_Users] FOREIGN KEY([UserId])
REFERENCES [dbo].[BAR_Users] ([Id])
GO
ALTER TABLE [dbo].[BAR_Comment] CHECK CONSTRAINT [FK_BAR_Comment_BAR_Users]
GO
ALTER TABLE [dbo].[BAR_Discount]  WITH CHECK ADD  CONSTRAINT [FK_BAR_Discount_BAR_Restaurant] FOREIGN KEY([RestaunrantId])
REFERENCES [dbo].[BAR_Restaurant] ([Id])
GO
ALTER TABLE [dbo].[BAR_Discount] CHECK CONSTRAINT [FK_BAR_Discount_BAR_Restaurant]
GO
ALTER TABLE [dbo].[BAR_Dish]  WITH CHECK ADD  CONSTRAINT [FK_BAR_Menu_BAR_Restaurant] FOREIGN KEY([RestaurantId])
REFERENCES [dbo].[BAR_Restaurant] ([Id])
GO
ALTER TABLE [dbo].[BAR_Dish] CHECK CONSTRAINT [FK_BAR_Menu_BAR_Restaurant]
GO
ALTER TABLE [dbo].[BAR_DishCategory]  WITH CHECK ADD  CONSTRAINT [FK_BAR_MenuCategory_BAR_Restaurant] FOREIGN KEY([RestaurantId])
REFERENCES [dbo].[BAR_Restaurant] ([Id])
GO
ALTER TABLE [dbo].[BAR_DishCategory] CHECK CONSTRAINT [FK_BAR_MenuCategory_BAR_Restaurant]
GO
ALTER TABLE [dbo].[BAR_LocationFilter]  WITH CHECK ADD  CONSTRAINT [FK_BAR_LocationFilter_BAR_Location] FOREIGN KEY([LocationId])
REFERENCES [dbo].[BAR_Location] ([Id])
GO
ALTER TABLE [dbo].[BAR_LocationFilter] CHECK CONSTRAINT [FK_BAR_LocationFilter_BAR_Location]
GO
ALTER TABLE [dbo].[BAR_LocationFilter]  WITH CHECK ADD  CONSTRAINT [FK_BAR_LocationFilter_BAR_Restaurant] FOREIGN KEY([RestaurantId])
REFERENCES [dbo].[BAR_Restaurant] ([Id])
GO
ALTER TABLE [dbo].[BAR_LocationFilter] CHECK CONSTRAINT [FK_BAR_LocationFilter_BAR_Restaurant]
GO
ALTER TABLE [dbo].[BAR_Order]  WITH CHECK ADD  CONSTRAINT [FK_BAR_Order_BAR_Restaurant] FOREIGN KEY([RestaurantId])
REFERENCES [dbo].[BAR_Restaurant] ([Id])
GO
ALTER TABLE [dbo].[BAR_Order] CHECK CONSTRAINT [FK_BAR_Order_BAR_Restaurant]
GO
ALTER TABLE [dbo].[BAR_Order]  WITH CHECK ADD  CONSTRAINT [FK_BAR_Order_BAR_Users] FOREIGN KEY([UserId])
REFERENCES [dbo].[BAR_Users] ([Id])
GO
ALTER TABLE [dbo].[BAR_Order] CHECK CONSTRAINT [FK_BAR_Order_BAR_Users]
GO
ALTER TABLE [dbo].[BAR_Order]  WITH CHECK ADD  CONSTRAINT [FK_BAR_Order_BAR_VoucherCode] FOREIGN KEY([VourcherId])
REFERENCES [dbo].[BAR_VoucherCode] ([Id])
GO
ALTER TABLE [dbo].[BAR_Order] CHECK CONSTRAINT [FK_BAR_Order_BAR_VoucherCode]
GO
ALTER TABLE [dbo].[BAR_OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_BAR_OrderDetails_BAR_Menu] FOREIGN KEY([DishId])
REFERENCES [dbo].[BAR_Dish] ([Id])
GO
ALTER TABLE [dbo].[BAR_OrderDetails] CHECK CONSTRAINT [FK_BAR_OrderDetails_BAR_Menu]
GO
ALTER TABLE [dbo].[BAR_OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_BAR_OrderDetails_BAR_Order] FOREIGN KEY([OrderId])
REFERENCES [dbo].[BAR_Order] ([Id])
GO
ALTER TABLE [dbo].[BAR_OrderDetails] CHECK CONSTRAINT [FK_BAR_OrderDetails_BAR_Order]
GO
ALTER TABLE [dbo].[BAR_UserDetails]  WITH CHECK ADD  CONSTRAINT [FK_BAR_UserDetails_BAR_Users] FOREIGN KEY([Id])
REFERENCES [dbo].[BAR_Users] ([Id])
GO
ALTER TABLE [dbo].[BAR_UserDetails] CHECK CONSTRAINT [FK_BAR_UserDetails_BAR_Users]
GO
ALTER TABLE [dbo].[BAR_Users]  WITH CHECK ADD  CONSTRAINT [FK_BAR_Users_BAR_Roles] FOREIGN KEY([RoleId])
REFERENCES [dbo].[BAR_Roles] ([Id])
GO
ALTER TABLE [dbo].[BAR_Users] CHECK CONSTRAINT [FK_BAR_Users_BAR_Roles]
GO
