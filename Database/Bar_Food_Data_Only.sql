USE [BAR_Food]
GO
SET IDENTITY_INSERT [dbo].[BAR_Restaurant] ON 

GO
INSERT [dbo].[BAR_Restaurant] ([Id], [Name], [Latitute], [Longtitue], [Address], [Description], [PhoneNum], [MinimumOrder], [OpenHours], [CloseHours], [isActive]) VALUES (1, N'Quán ăn sân vườn Thành Tựu', CAST(10 AS Decimal(18, 0)), CAST(10 AS Decimal(18, 0)), N'270B Bắc Hải Kios 15 Đường Bắc Hải - Phường 6 - Quận Tân Bình - Tp.HCM', N'Quán đặc sản Nam Bộ Thành Tựu nổi tiếng với các món ăn ngon, giá cả bình dân và khung cảnh đẹp như miền quê.', N'0972 858 881', 1.0000, CAST(0x0000A14D00735B40 AS DateTime), CAST(0x0000A14D016A8C80 AS DateTime), 1)
GO
INSERT [dbo].[BAR_Restaurant] ([Id], [Name], [Latitute], [Longtitue], [Address], [Description], [PhoneNum], [MinimumOrder], [OpenHours], [CloseHours], [isActive]) VALUES (2, N'Nhà hàng 666', CAST(10 AS Decimal(18, 0)), CAST(10 AS Decimal(18, 0)), N'666 Nguyễn Cửu Vân – Phường 17 – Quận Tân Bình – Tp.HCM', N'Không gian thưởng thức thoải mái, đa dạng các món ăn được chế biến từ nguồn hải sản chất lượng...', N'0972 858 881', 1.0000, CAST(0x0000A14D00735B40 AS DateTime), CAST(0x0000A14D016A8C80 AS DateTime), 1)
GO
INSERT [dbo].[BAR_Restaurant] ([Id], [Name], [Latitute], [Longtitue], [Address], [Description], [PhoneNum], [MinimumOrder], [OpenHours], [CloseHours], [isActive]) VALUES (3, N'Quán nhậu đặc sản Vườn Quê', CAST(10 AS Decimal(18, 0)), CAST(10 AS Decimal(18, 0)), N'B463 Nguyễn Văn Quá – Phường Đông Hưng Thuận 10 – Quận 12 – Tp.HCM', N'Quán nhậu đặc sản Vườn Quê mang đến cho thực khách hơn 60 nguyên liệu chính được chế biến với hàng trăm món ăn khác nhau. Tất cả đều được chăm chút bởi các đầu bếp giàu kinh nghiệm.', N'0972 858 881', 1.0000, CAST(0x0000A14D00735B40 AS DateTime), CAST(0x0000A14D016A8C80 AS DateTime), 1)
GO
INSERT [dbo].[BAR_Restaurant] ([Id], [Name], [Latitute], [Longtitue], [Address], [Description], [PhoneNum], [MinimumOrder], [OpenHours], [CloseHours], [isActive]) VALUES (4, N'Nhà hàng Ga Việt', CAST(10 AS Decimal(18, 0)), CAST(10 AS Decimal(18, 0)), N'131 Nguyễn Phúc Nguyên – Phường 10 – Quận 3 – Tp.HCM', N'Một lần đến với nhà hàng Ga Việt, bạn sẽ có cơ hội trải nghiệm đủ hương vị của món cá lăng - món ăn được xem là “đặc sản Sông Mã”.', N'0972 858 881', 1.0000, CAST(0x0000A14D00735B40 AS DateTime), CAST(0x0000A14D016A8C80 AS DateTime), 1)
GO
INSERT [dbo].[BAR_Restaurant] ([Id], [Name], [Latitute], [Longtitue], [Address], [Description], [PhoneNum], [MinimumOrder], [OpenHours], [CloseHours], [isActive]) VALUES (5, N'Quán chay Sen Việt 2', CAST(10 AS Decimal(18, 0)), CAST(10 AS Decimal(18, 0)), N'72 Bình Giã – Phường 13 – Quận Tân Bình – Tp.HCM', N'Quán chay Sen Việt 2 là điểm đến chuyên phục vụ các món ăn chay với thực đơn phong phú, được thay đổi hàng ngày.', N'0972 858 881', 1.0000, CAST(0x0000A14D00735B40 AS DateTime), CAST(0x0000A14D016A8C80 AS DateTime), 1)
GO
INSERT [dbo].[BAR_Restaurant] ([Id], [Name], [Latitute], [Longtitue], [Address], [Description], [PhoneNum], [MinimumOrder], [OpenHours], [CloseHours], [isActive]) VALUES (55, N'dsds', CAST(21 AS Decimal(18, 0)), CAST(1 AS Decimal(18, 0)), N'rew', N'rewrw', N'erqw', 0.0000, CAST(0x0000A15100000000 AS DateTime), CAST(0x0000A15100000000 AS DateTime), NULL)
GO
INSERT [dbo].[BAR_Restaurant] ([Id], [Name], [Latitute], [Longtitue], [Address], [Description], [PhoneNum], [MinimumOrder], [OpenHours], [CloseHours], [isActive]) VALUES (56, N'dsds', CAST(21 AS Decimal(18, 0)), CAST(1 AS Decimal(18, 0)), N'rew', N'rewrw', N'erqw', 0.0000, CAST(0x0000A15100000000 AS DateTime), CAST(0x0000A15100000000 AS DateTime), NULL)
GO
SET IDENTITY_INSERT [dbo].[BAR_Restaurant] OFF
GO
SET IDENTITY_INSERT [dbo].[BAR_DishCategory] ON 

GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (1, 1, N'Ăn nhẹ', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (2, 1, N'Ăn cay', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (3, 1, N'Ăn vặt', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (4, 1, N'Món uống', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (5, 1, N'Ăn sáng', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (6, 1, N'Các món bún', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (7, 1, N'Các món nước', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (8, 1, N'Các món nướng', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (9, 2, N'Món bò', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (10, 2, N'Món gà', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (11, 2, N'Món tôm', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (12, 2, N'Đồ uống', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (13, 3, N'Thịt rừng', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (14, 3, N'Rau,củ, quả', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (15, 3, N'Tiềm', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (16, 3, N'Ăn chay', NULL)
GO
INSERT [dbo].[BAR_DishCategory] ([Id], [RestaurantId], [Name], [isActive]) VALUES (17, 3, N'Chả', NULL)
GO
SET IDENTITY_INSERT [dbo].[BAR_DishCategory] OFF
GO
