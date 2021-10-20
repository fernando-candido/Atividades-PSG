DROP TABLE [dbo].[RawDepartamentos]
DROP TABLE [dbo].[RawFuncionariosDadosEmpresa]
DROP TABLE [RawFuncionariosDados Pessoais]
DROP TABLE [dbo].[RawPais]


SELECT * FROM Pais
SELECT * FROM Departamentos
SELECT * FROM Funcionario


CREATE TABLE Funcionario(
	FuncionarioID INT NOT NULL,
	ChaveID BIGINT NOT NULL,
	Nome VARCHAR(MAX) NOT NULL,
	SobreNome VARCHAR(MAX) NOT NULL,
	DataAdmissao DATETIME2 NOT NULL,
	Sexo VARCHAR(1) NOT NULL,
	DataNascimento DATETIME2 NOT NULL,
	Email VARCHAR(MAX) NOT NULL,
	CTPS VARCHAR (MAX) NOT NULL,
	CTPSNum BIGINT NOT NULL,
	CTPSSERIE INT NOT NULL,
	PaisID VARCHAR(50) NOT NULL,
	DataInsert DATETIME NULL DEFAULT GETDATE(),
	CONSTRAINT PK_Funcionario PRIMARY KEY (FuncionarioID)
)

SELECT * FROM Funcionario

INSERT INTO Funcionario (FuncionarioID, ChaveID, Nome, SobreNome, DataAdmissao, Sexo, DataNascimento, Email, CTPS, CTPSNum, CTPSSerie, PaisID)
SELECT
Pessoais.FuncionarioID,
Empresa.ChaveID,
Empresa.Nome,
Empresa.SobreNome,
Empresa.DataAdmissao,
Pessoais.Sexo,
Pessoais.DataNascimento,
Pessoais.Email,
Empresa.CTPS,
Empresa.CTPSNum,
Empresa.CTPSSerie,
Pessoais.PaisID
FROM RawFuncionariosDadosEmpresa AS Empresa
INNER JOIN [RawFuncionariosDados Pessoais] AS Pessoais ON Empresa.ChaveID = Pessoais.ChaveID
ORDER BY Pessoais.FuncionarioID



CREATE TABLE Pais(
	PaisID INT NOT NULL IDENTITY(1,1),
	Nome VARCHAR(50) NOT NULL,
	Sigla VARCHAR(50) NOT NULL,
	DataInsert DATETIME NULL DEFAULT GETDATE(),
	CONSTRAINT PK_Pais PRIMARY KEY (PaisID)

)

SET IDENTITY_INSERT Pais ON

INSERT INTO Pais(PaisID, Nome, Sigla)
SELECT PaisID, Nome, Abreviacao FROM RawPais

SET IDENTITY_INSERT Pais OFF


-- Criando a tabela Departamentos e inserindo valor nela com a tabelela temporaria RawDepartamentos.

CREATE TABLE Departamentos(
	DepartamentoID INT NOT NULL IDENTITY(1,1),
	Nome VARCHAR(MAX) NOT NULL,
	DataInsert DATETIME NULL DEFAULT GETDATE()
	CONSTRAINT PK_Departamento PRIMARY KEY (DepartamentoID)
)


SET IDENTITY_INSERT Departamentos ON
INSERT INTO  Departamentos(DepartamentoID, Nome)
SELECT DepartamentoID, Nome FROM RawDepartamentos
SET IDENTITY_INSERT Departamentos OFF

/*
CREATE VIEW VW_DadosPessoais
AS
SELECT 
	FuncionarioID,
	ChaveID,
	Nome AS NomeFuncionario,
	SobreNome,
	DataAdmissao, 
	Sexo, 
	DataNascimento, 
	Email
	FROM Funcionario

SELECT * FROM VW_DadosPessoais

*/




/*


CREATE VIEW VW_DadosEmpresa
AS
SELECT 
	FuncionarioID,
	ChaveID,
	Nome AS NomeFuncionario,
	SobreNome,
	DataAdmissao, 
	Sexo, 
	DataNascimento, 
	Email,
	CTPS,
	CTPSNum,
	CTPSSERIE
	FROM Funcionario

*/
SELECT * FROM VW_DadosPessoais

SELECT * FROM VW_DadosEmpresa



CREATE PROCEDURE PR_BuscaFuncionarioID
	@FuncionarioID INT
AS
SELECT * FROM Funcionario
WHERE FuncionarioID = @FuncionarioID

EXECUTE PR_BuscaFuncionarioID 10001
GO



CREATE PROCEDURE PR_BuscaPorChaveID
	@ChaveID BIGINT
AS
SELECT * FROM Funcionario
WHERE ChaveID = @ChaveID


EXECUTE PR_BuscaPorChaveID 20100150001

