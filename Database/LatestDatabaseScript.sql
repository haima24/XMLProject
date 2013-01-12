USE [BAR_Food]
GO
/****** Object:  Table [dbo].[BAR_Restaurant]    Script Date: 01/12/2013 17:18:58 ******/
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
	[CloseHours] [datetime] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BAR_LocationFilter]    Script Date: 01/12/2013 17:18:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_LocationFilter](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RestaurantId] [int] NULL,
	[LocationId] [int] NULL,
	[isDeliverable] [bit] NULL,
	[DeliveryFee] [money] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BAR_Roles]    Script Date: 01/12/2013 17:18:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BAR_Roles](
	[Id] [int] NULL,
	[Roles] [varchar](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BAR_Location]    Script Date: 01/12/2013 17:18:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_Location](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[LocationName] [nvarchar](50) NULL,
	[LocationLevel] [int] NULL,
	[ParentId] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BAR_Users]    Script Date: 01/12/2013 17:19:07 ******/
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
	[isActive] [bit] NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BAR_Discount]    Script Date: 01/12/2013 17:18:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_Discount](
	[Id] [int] NULL,
	[RestaunrantId] [int] NULL,
	[Value] [int] NULL,
	[BeginDate] [datetime] NULL,
	[EndDate] [datetime] NULL,
	[isActive] [bit] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BAR_Order]    Script Date: 01/12/2013 17:18:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_Order](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NULL,
	[RestaurantId] [int] NOT NULL,
	[VourcherId] [int] NULL,
	[Date] [datetime] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BAR_VoucherCode]    Script Date: 01/12/2013 17:19:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BAR_VoucherCode](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Code] [varchar](10) NULL,
	[isActive] [bit] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[BAR_Menu]    Script Date: 01/12/2013 17:18:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_Menu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RestaurantId] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](50) NULL,
	[Price] [money] NULL,
	[CategoryId] [int] NULL,
	[isActive] [bit] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BAR_MenuCategory]    Script Date: 01/12/2013 17:18:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_MenuCategory](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RestaurantId] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[isActive] [bit] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BAR_OrderDetails]    Script Date: 01/12/2013 17:18:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAR_OrderDetails](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NULL,
	[MenuId] [int] NULL,
	[Quantity] [int] NULL,
	[Price] [money] NULL,
	[TotalPrice] [money] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BAR_Comment]    Script Date: 01/12/2013 17:18:39 ******/
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
	[isActive] [bit] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BAR_UserDetails]    Script Date: 01/12/2013 17:19:05 ******/
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
	[PhoneNum] [varchar](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
