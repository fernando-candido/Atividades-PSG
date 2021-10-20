/*

USE [Atividade 2021-09-24]
GO

/****** Object:  Table [dbo].[RawFuncionariosDados Pessoais]    Script Date: 24/09/2021 15:03:41 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RawFuncionariosDados Pessoais](
	[FuncionarioID] [int] NOT NULL,
	[ChaveID] [bigint] NOT NULL,
	[Nome] [varchar](max) NOT NULL,
	[SobreNome] [varchar](max) NOT NULL,
	[Sexo] [varchar](50) NOT NULL,
	[DataNascimento] [datetime2](7) NOT NULL,
	[Email] [varchar](max) NOT NULL,
	[PaisID] [varchar](50) NOT NULL,
 CONSTRAINT [PK_RawFuncionariosDados Pessoais] PRIMARY KEY CLUSTERED 
(
	[FuncionarioID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO



---------------------------------------------------------------------------------------------------------------------------------------------------


USE [Atividade 2021-09-24]
GO

/****** Object:  Table [dbo].[RawFuncionariosDadosEmpresa]    Script Date: 24/09/2021 15:04:16 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RawFuncionariosDadosEmpresa](
	[ChaveID] [bigint] NOT NULL,
	[Nome] [varchar](max) NOT NULL,
	[SobreNome] [varchar](max) NOT NULL,
	[DataAdmissao] [datetime2](7) NOT NULL,
	[CTPS] [varchar](max) NOT NULL,
	[CTPSNum] [bigint] NOT NULL,
	[CTPSSerie] [int] NOT NULL,
 CONSTRAINT [PK_RawFuncionariosDadosEmpresa] PRIMARY KEY CLUSTERED 
(
	[ChaveID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO



------------------------------------------------------------------------------------------------------------------------------------------------------------------------


USE [Atividade 2021-09-24]
GO

/****** Object:  Table [dbo].[RawDepartamentos]    Script Date: 24/09/2021 15:04:52 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RawDepartamentos](
	[DepartamentoID] [int] NOT NULL,
	[Nome] [varchar](max) NOT NULL,
 CONSTRAINT [PK_RawDepartamentos] PRIMARY KEY CLUSTERED 
(
	[DepartamentoID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO



-----------------------------------------------------------------------------------------------------------------------------------------------------------


USE [Atividade 2021-09-24]
GO

/****** Object:  Table [dbo].[RawPais]    Script Date: 24/09/2021 15:05:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[RawPais](
	[PaisID] [varchar](50) NOT NULL,
	[Nome] [varchar](max) NOT NULL,
	[Abreviacao] [varchar](50) NOT NULL,
 CONSTRAINT [PK_RawPais] PRIMARY KEY CLUSTERED 
(
	[PaisID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO







*/