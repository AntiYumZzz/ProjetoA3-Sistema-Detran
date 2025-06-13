import javax.swing.*; // Componentes gráficos Swing
import javax.swing.border.*; // Bordas para componentes Swing
import java.awt.*; // Layouts e gerenciamento de janelas
import java.awt.event.*; //Gerenciamento de butoes
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;





public class Interface {

    // Método para salvar os usuários em um arquivo TXT
    public static void salvarUsuarios(Proprietario users) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt", true));
            bw.write("Nome: " + users.nome);
            bw.newLine();
            bw.write("CPF: " + users.cpf);
            bw.newLine();
            bw.write("Senha: " + users.senha);
            bw.newLine();
            bw.write("E-mail: " + users.email);
            bw.newLine();
            bw.write("Data de nascimento: " + users.dataNascimento);
            bw.newLine();
            bw.write("Telefone: " + users.telefone);
            bw.newLine();
            bw.write("-----------------------------");
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Criação da janela principal do sistema
        JFrame frame = new JFrame("Sistema Detran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Janela inicia maximizada
        frame.getContentPane().setBackground(new Color(182, 182, 182)); // Cor de fundo cinza claro
        frame.setLayout(new GridBagLayout()); // Layout flexível para dimensionamento dos componentes

        // Painel principal que contém as páginas (cards) controladas pelo CardLayout
        JPanel cards = new JPanel(new CardLayout());

        // Criação das diferentes páginas/telas do sistema
        JPanel loginPage = createLoginPanel(cards); // Tela de login
        JPanel registerPage = createRegisterPanel(cards); // Tela de cadastro de usuário
        JPanel mainPage = createMainPanel(cards, "Usuario"); // Tela principal após login, com nome de usuário padrão
        JPanel vehicleRegistrationPage = createVehicleRegistrationPanel(cards); // Tela de cadastro de veículos
        JPanel vehicleTransferencePage = createVehicleTransferencePanel(cards); // Tela de transferência de veículos

        // Adiciona as páginas ao painel principal com identificadores únicos
        cards.add(loginPage, "Login");
        cards.add(registerPage, "Register");
        cards.add(mainPage, "Main");
        cards.add(vehicleRegistrationPage, "VehicleRegistration");
        cards.add(vehicleTransferencePage, "VehicleTransference");

        // Configuração para ocupar todo o espaço disponível na janela
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Preencher horizontal e verticalmente
        gbc.weightx = 1; // Peso para redimensionamento horizontal
        gbc.weighty = 1; // Peso para redimensionamento vertical

        frame.add(cards, gbc); // Adiciona o painel de páginas à janela principal
        frame.setSize(1200, 800); // Tamanho inicial antes de maximizar
        frame.setVisible(true); // Exibe a janela
    }

    // Méyodo para criar a tela de login
    private static JPanel createLoginPanel(JPanel cards) {
        // Título superior do sistema
        JLabel titleLabel = new JLabel("Sistema Detran");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0)); // Espaçamento inferior

        // Painel com campos de login e botões
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS)); // Layout vertical (coluna)
        loginPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY, 2), // Borda cinza
                        "", TitledBorder.LEFT, TitledBorder.TOP,
                        new Font("Arial", Font.BOLD, 16),
                        Color.DARK_GRAY
                ),
                BorderFactory.createEmptyBorder(20, 20, 20, 20) // Espaçamento interno
        ));
        loginPanel.setPreferredSize(new Dimension(400, 600)); // Tamanho preferido do painel

        // Label "Login"
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 26));

        // Campo para usuário
        JTextField username = new JTextField(20);
        username.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Campo para senha
        JPasswordField password = new JPasswordField(20);
        password.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        password.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Label para mensagens de erro
        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botão para realizar login
        JButton loginButton = new JButton("Entrar");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 20));
        loginButton.setMaximumSize(new Dimension(200, 40));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ação do botão login - valida se os campos não estão vazios
        loginButton.addActionListener(e -> {
            String user = username.getText();
            String pass = new String(password.getPassword());

            if (!user.isEmpty() && !pass.isEmpty()) {
                errorLabel.setText(""); // Limpa mensagem de erro

                // TODO: Aqui deve ser inserida a lógica real de autenticação contra banco de dados ou sistema

                // Após sucesso, troca para tela principal passando o nome do usuário
                CardLayout cl = (CardLayout) cards.getLayout();
                cards.add(createMainPanel(cards, user), "Main");
                cl.show(cards, "Main");
            } else {
                errorLabel.setText("Por favor, preencha todos os campos."); // Mensagem de erro
            }
        });

        // Botão para ir para a tela de cadastro de novo usuário
        JButton registerButton = new JButton("<html><u>Cadastre-se</u></html>");
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setMnemonic('C'); // Atalho de teclado: Alt + C
        registerButton.setForeground(Color.BLUE);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.setFont(new Font("Arial", Font.PLAIN, 12));
        registerButton.setMaximumSize(new Dimension(200, 40));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        registerButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.show(cards, "Register"); // Mostra tela de cadastro
        });

        // Adiciona os componentes ao painel de login
        loginPanel.add(loginLabel);
        loginPanel.add(Box.createVerticalStrut(30)); // Espaço vertical
        loginPanel.add(username);
        loginPanel.add(Box.createVerticalStrut(30));
        loginPanel.add(password);
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(errorLabel);
        loginPanel.add(Box.createVerticalStrut(20));
        loginPanel.add(loginButton);
        loginPanel.add(Box.createVerticalStrut(30));
        loginPanel.add(registerButton);

        // Combina título e formulário verticalmente
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(titleLabel);
        verticalBox.add(loginPanel);

        // Painel externo para centralizar na tela e adicionar margens laterais
        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(new Color(182, 182, 182));
        container.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 150)); // Margem esquerda e direita
        container.add(verticalBox);
        container.setMaximumSize(new Dimension(480, Integer.MAX_VALUE));

        return container;
    }

    // Tela principal após login bem-sucedido
    private static JPanel createMainPanel(JPanel cards, String username) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(182, 182, 182));

        // Mensagem de boas-vindas com o nome do usuário
        JLabel title = new JLabel("Bem vindo, " + username + ".");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

        // Painel para botões organizados em grade 2x2
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        buttonPanel.setMaximumSize(new Dimension(600, 300));
        buttonPanel.setOpaque(false);

        // Texto dos botões principais do menu
        String[] labels = {
                "<html>Cadastro<br>Veículos</html>",
                "Relatório",
                "<html>Transferência<br>de Veículos</html>",
                "Consultar"
        };

        JButton[] buttons = new JButton[4];

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton(labels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            buttons[i].setPreferredSize(new Dimension(200, 80));
            buttonPanel.add(buttons[i]);
        }

        // Botão "Cadastro Veículos" abre a tela de cadastro de veículos
        buttons[0].addActionListener(e -> {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.show(cards, "VehicleRegistration");
        });

        // Botão "Transferência de Veículos" abre a tela correspondente
        buttons[2].addActionListener(e -> {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.show(cards, "VehicleTransference");
        });

        // TODO: Implementar ações para "Relatório" e "Consultar"

        panel.add(title);
        panel.add(buttonPanel);

        return panel;
    }

    // Tela para cadastro de novo usuário
    private static JPanel createRegisterPanel(JPanel cards) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(182, 182, 182));

        JLabel title = new JLabel("Página de Cadastro");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        // Painel com campos do formulário, em grade 3x2
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        formPanel.setMaximumSize(new Dimension(800, 200));
        formPanel.setOpaque(false);

        // Labels para campos do formulário
        String[] labels = {
                "Nome", "Data Nascimento",
                "CPF", "Email",
                "Senha", "Confirmar Senha"
        };

        // Campos de texto simples para entrada de dados
        // Campos do formulário
        JTextField nomeField = new CaixaTexto("Digite seu nome");
        JTextField cpfField = new CaixaTexto("Digite seu CPF");
        JPasswordField senhaField = new CaixaSenha("Digite sua senha");
        JTextField emailField = new CaixaTexto("Digite seu e-mail");
        JTextField nascimentoField = new CaixaTexto("DD/MM/AAAA");
        JTextField telefoneField = new CaixaTexto("(xx) xxxxx-xxxx");


         // Layout com GridLayout
        formPanel.add(new JLabel("Nome:"));
        formPanel.add(nomeField);
        formPanel.add(new JLabel("CPF:"));
        formPanel.add(cpfField);
        formPanel.add(new JLabel("Senha:"));
        formPanel.add(senhaField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Data Nascimento:"));
        formPanel.add(nascimentoField);
        formPanel.add(new JLabel("Telefone:"));
        formPanel.add(telefoneField);

        // Botão para finalizar cadastro (implementação pendente)
        JButton finishButton = new JButton("Finalizar Cadastro");
        finishButton.setFont(new Font("Arial", Font.PLAIN, 20));
        finishButton.setMaximumSize(new Dimension(200, 40));
        finishButton.setAlignmentX(Component.CENTER_ALIGNMENT);



        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String senha = new String(senhaField.getPassword());
                String email = emailField.getText();
                String nascimento = nascimentoField.getText();
                String telefone = telefoneField.getText();

                // Validação simples de senha

                // Criar e preencher os dados do usuário
                Proprietario novoUsuario = new Proprietario();
                novoUsuario.nome = nome;
                novoUsuario.cpf = cpf;
                novoUsuario.senha = senha;
                novoUsuario.email = email;
                novoUsuario.dataNascimento = nascimento;
                novoUsuario.telefone = telefone;

                salvarUsuarios(novoUsuario);

                // Mensagem e redirecionamento
                JOptionPane.showMessageDialog(panel, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, "Login");
            }
        });






        // TODO: implementar lógica para validação e envio dos dados para backend

        // Botão para voltar à tela de login
        JButton backButton = new JButton("Voltar para Login");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setMaximumSize(new Dimension(200, 40));
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.show(cards, "Login");
        });

        panel.add(title);
        panel.add(formPanel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(finishButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(backButton);

        return panel;
    }

    // Tela de cadastro de veículos (exemplo com campos básicos)
    private static JPanel createVehicleRegistrationPanel(JPanel cards) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(182, 182, 182));

        // Título da tela
        JLabel title = new JLabel("Cadastro de Veículos");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        panel.add(title, BorderLayout.NORTH);

        // Painel com os campos do formulário
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        panel.add(formPanel, BorderLayout.CENTER);

        // Tamanho dos campos de texto
        Dimension fieldSize = new Dimension(240, 35);

        // Criação dos rótulos e campos
        JLabel labelMarca = new JLabel("Marca:");
        JTextField fieldMarca = new JTextField();
        fieldMarca.setPreferredSize(fieldSize);

        JLabel labelModelo = new JLabel("Modelo:");
        JTextField fieldModelo = new JTextField();
        fieldModelo.setPreferredSize(fieldSize);

        JLabel labelCor = new JLabel("Cor:");
        JTextField fieldCor = new JTextField();
        fieldCor.setPreferredSize(fieldSize);

        JLabel labelAno = new JLabel("Ano:");
        JTextField fieldAno = new JTextField();
        fieldAno.setPreferredSize(fieldSize);

        JLabel labelPlaca = new JLabel("Placa:");
        JTextField fieldPlaca = new JTextField();
        fieldPlaca.setPreferredSize(fieldSize);

        // Restringe o campo 'Ano' para aceitar apenas números
        fieldAno.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '\b') {
                    e.consume();
                }
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 10, 4, 10); // Espaçamento pequeno entre label e campo
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        // Primeira linha: Marca e Modelo
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(labelMarca, gbc);
        gbc.gridy = 1;
        formPanel.add(fieldMarca, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(labelModelo, gbc);
        gbc.gridy = 1;
        formPanel.add(fieldModelo, gbc);

        // Segunda linha: Cor e Ano
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(labelCor, gbc);
        gbc.gridy = 3;
        formPanel.add(fieldCor, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(labelAno, gbc);
        gbc.gridy = 3;
        formPanel.add(fieldAno, gbc);

        // Terceira linha: Placa (alinhada com a segunda coluna)
        gbc.gridx = 1;
        gbc.gridy = 4;
        formPanel.add(labelPlaca, gbc);
        gbc.gridy = 5;
        formPanel.add(fieldPlaca, gbc);

        // Painel inferior com botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));

        JButton saveButton = new JButton("Salvar");
        saveButton.setFont(new Font("Arial", Font.PLAIN, 20));
        saveButton.setMaximumSize(new Dimension(200, 40));
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("Voltar");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setMaximumSize(new Dimension(200, 40));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ação do botão voltar
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.show(cards, "Main");
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createVerticalStrut(15)); // Espaço entre botões
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }


    // Tela de transferência de veículos (exemplo simples)
    private static JPanel createVehicleTransferencePanel(JPanel cards) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(182, 182, 182));

        JLabel title = new JLabel("Transferência de Veículos");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        Dimension fieldSize = new Dimension(300, 35);
        Dimension smallFieldSize = new Dimension(150, 30);

        // ComboBox de seleção de veículos
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Veículo:"), gbc);

        gbc.gridx = 1;
        String[] veiculos = { "Veículo 1", "Veículo 2" }; // Placeholder, facilmente extensível
        JComboBox<String> veiculoComboBox = new JComboBox<>(veiculos);
        veiculoComboBox.setPreferredSize(smallFieldSize);
        formPanel.add(veiculoComboBox, gbc);

        // Campo Remetente
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Remetente:"), gbc);

        gbc.gridx = 1;
        JTextField remetenteField = new JTextField();
        remetenteField.setPreferredSize(fieldSize);
        remetenteField.setMaximumSize(fieldSize);
        formPanel.add(remetenteField, gbc);

        // Campo Destinatário
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Destinatário:"), gbc);

        gbc.gridx = 1;
        JTextField destinatarioField = new JTextField();
        destinatarioField.setPreferredSize(fieldSize);
        destinatarioField.setMaximumSize(fieldSize);
        formPanel.add(destinatarioField, gbc);

        // Campo Data para Transferência
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Data P/ Transferência:"), gbc);

        gbc.gridx = 1;
        JTextField dataField = new JTextField();
        dataField.setPreferredSize(fieldSize);
        dataField.setMaximumSize(fieldSize);
        formPanel.add(dataField, gbc);

        // Painel para os botões, centralizado
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton transferButton = new JButton("Transferir");
        transferButton.setFont(new Font("Arial", Font.PLAIN, 20));
        transferButton.setPreferredSize(new Dimension(200, 40));

        JButton backButton = new JButton("Voltar para Menu");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setPreferredSize(new Dimension(200, 40));
        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) cards.getLayout();
            cl.show(cards, "Main");
        });

        buttonPanel.add(transferButton);
        buttonPanel.add(backButton);

        panel.add(title);
        panel.add(formPanel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(buttonPanel);

        return panel;
    }
}
