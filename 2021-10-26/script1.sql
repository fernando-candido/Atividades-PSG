--DROP TABLE DepartamentoPorFuncionario;

CREATE TABLE DepartamentoPorFuncionario(
	
	FuncionarioDepartamento int not null identity(1,1),
	FuncionarioID INT NOT NULL,
	DepartamentoID INT NOT NULL,
	DataInicial DATETIME NOT NULL,
	DataFinal DATETIME NOT NULL,
	CONSTRAINT PK_FuncionarioDepartamento PRIMARY KEY (FuncionarioDepartamento),
	CONSTRAINT FK_FuncionarioID FOREIGN KEY (FuncionarioID) REFERENCES Funcionario(FuncionarioID),
	CONSTRAINT FK_DepartamentoID FOREIGN KEY (DepartamentoID) REFERENCES Departamento(DepartamentoID)
)

SELECT * FROM DepartamentoPorFuncionario

--Inserindo da tabela Raw na Tabela departamento por funcionario
INSERT INTO DepartamentoPorFuncionario(FuncionarioID, DepartamentoID, DataInicial, DataFinal)
SELECT
	funcid,
	deptoid,
	DataInicial,
	DataFinal
	FROM [dbo].[RAWDATA_Funcionarios_Por_Deptos] AS FUNC
	ORDER BY funcid
----------------------------------------------------------------

select * from [dbo].[RAWDATA_Funcionarios_Por_Deptos];



SELECT 
F.FuncionarioID,
F.Chave,
FD.FuncionarioDepartamento,
D.Nome
FROM  Funcionario as F
INNER JOIN DepartamentoPorFuncionario as FD ON F.FuncionarioID = FD.FuncionarioID
INNER JOIN Departamento as D ON D.DepartamentoID = FD.DepartamentoID
GO
