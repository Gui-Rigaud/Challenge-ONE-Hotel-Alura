package br.com.hotelalura.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.hotelalura.controllers.HospedeController;
import br.com.hotelalura.controllers.ReservaController;
import br.com.hotelalura.modelo.Hospede;
import br.com.hotelalura.modelo.Reserva;

@SuppressWarnings("serial")
public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHospedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHospedes;
	private JLabel labelAtras;
	private JLabel labelExit;
	private HospedeController hospedeController = new HospedeController();
	private ReservaController reservaController = new ReservaController();
	private Object objetoDaLinha;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public Buscar() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Buscar.class.getResource("/br/com/hotelalura/views/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblTitulo.setBounds(331, 62, 280, 42);
		contentPane.add(lblTitulo);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Data Check In");
		modelo.addColumn("Data Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas",
				new ImageIcon(Buscar.class.getResource("/br/com/hotelalura/views/imagenes/reservado.png")),
				scroll_table, "Reservas");
		scroll_table.setVisible(true);

		tbHospedes = new JTable();
		tbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHospedes = (DefaultTableModel) tbHospedes.getModel();
		modeloHospedes.addColumn("Numero de Hóspede");
		modeloHospedes.addColumn("Nome");
		modeloHospedes.addColumn("Sobrenome");
		modeloHospedes.addColumn("Data de Nascimento");
		modeloHospedes.addColumn("Nacionalidade");
		modeloHospedes.addColumn("Telefone");
		modeloHospedes.addColumn("Numero de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHospedes);
		panel.addTab("Hóspedes",
				new ImageIcon(Buscar.class.getResource("/br/com/hotelalura/views/imagenes/pessoas.png")),
				scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2
				.setIcon(new ImageIcon(Buscar.class.getResource("/br/com/hotelalura/views/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) { // Quando o usuário passa o mouse sobre o botão, ele muda de cor
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Quando o usuário remove o mouse do botão, ele retornará ao estado
													// original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Hospede> hospede = new ArrayList<Hospede>();
				try {
					hospede = hospedeController.buscar(txtBuscar.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				limparTabela();
				preencherTabelaHospede(hospede);
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Object[] options = { "Minha Reserva", "Minha informações pessoais" };
					Object option = JOptionPane.showInputDialog(null,
							"Você editou sua Reserva ou suas informações pessoais?", "Escolha uma opção",
							JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

					if (option == options[0]) {

						alterarReserva();

					} else {
						alterarHospede();
					}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algo deu errado.");
					exc.printStackTrace();
				}
			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnDeletar = new JPanel();
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					deletarReserva();
					JOptionPane.showMessageDialog(null, "Reserva deletada com sucesso!");
					limparTabela();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algo deu errado.");
					exc.printStackTrace();
				}
			}
		});
		btnDeletar.setLayout(null);
		btnDeletar.setBackground(new Color(12, 138, 199));
		btnDeletar.setBounds(767, 508, 122, 35);
		btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnDeletar);

		JLabel lblExcluir = new JLabel("DELETAR");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblExcluir.setBounds(0, 0, 122, 35);
		btnDeletar.add(lblExcluir);
		setResizable(false);
	}

	private void limparTabela() {
		modelo.getDataVector().clear();
		modeloHospedes.getDataVector().clear();
	}

	private void preencherTabelaHospede(List<Hospede> h) {
		List<Hospede> hospedes = new ArrayList<Hospede>();
		hospedes = h;
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			for (Hospede hospede : hospedes) {
				modeloHospedes.addRow(new Object[] { hospede.getIdHospede(), hospede.getNome(), hospede.getSobrenome(),
						hospede.getDataDeNascimento(), hospede.getNacionalidade(), hospede.getTelefone(),
						hospede.getIdReserva() });
				reservas = hospede.getReservas();
			}

			for (Reserva reserva : reservas) {
				modelo.addRow(new Object[] { reserva.getId(), reserva.getDiaDeChegada(), reserva.getDiaDeSaida(),
						reserva.getValorDaReserva(), reserva.getFormaPagamento() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void alterarHospede() throws SQLException {
		Object objetoDaLinha = null;
		
		try {
			objetoDaLinha = (Object) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(),
					tbHospedes.getSelectedColumn());
		}catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o NÚMERO DE HÓSPEDE");
			return;
		}		
		if (objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			Integer idReserva = (Integer) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 6);
			if(id == idReserva) {
				JOptionPane.showMessageDialog(this, "Por favor, selecionar o NÚMERO DO HÓSPEDE");
			} else {
				String nome = (String) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 1);
				String sobrenome = (String) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 2);
				String dataNascimento = (String) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 3);
				String Nacionalidade = (String) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 4);
				String telefone = (String) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 5);
				this.hospedeController.alterar(id, nome, sobrenome, dataNascimento, Nacionalidade, telefone);
				JOptionPane.showMessageDialog(null, "Informação editada com sucesso!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
		}
	}
	
	private void alterarReserva() throws SQLException {
		Object objetoDaLinha = null;
		
		try {
			objetoDaLinha = (Object) modelo.getValueAt(tbReservas.getSelectedRow(),
					tbReservas.getSelectedColumn());
		}catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o NÚMERO DA RESERVA");
			return;
		}
		if (objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			String dataEntrada = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 1);
			String dataSaida = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 2);
			Double valor = Double.parseDouble(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
			String formaPagamento = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
			this.reservaController.alterar(id, dataEntrada, dataSaida, valor, formaPagamento);
			JOptionPane.showMessageDialog(null, "Informação editada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
		}
	}
	
	public void deletarReserva() {
		Object objetoDaLinha = (Object) modelo.getValueAt(tbReservas.getSelectedRow(),
				tbReservas.getSelectedColumn());
		
		if(objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			this.reservaController.deletarReserva(id);
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
		}
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
