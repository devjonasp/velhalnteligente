package JogoDaVelha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int escolha = 0;
		int jogadas;
		int temp1 = 0;
		int temp2 = 0;
		int coluna = 0;
		boolean bloqueio = false;
		boolean jogadaValida = false;
		boolean validado = false;
		boolean repetir = false;
		boolean maquinaVenceu = false;
		boolean usuarioVenceu = false;
		boolean empate = false;
		String[][] tabuleiro = new String[3][3];
		String jogar;

		do {
			System.out.println("BEM VINDO(A) À VelhaInteligente!");
			System.out.println();
			System.out.println("      MENU");
			System.out.println("================");
			System.out.println("[1] JOGAR AGORA");
			System.out.println("[2] COMO JOGAR");
			System.out.println("[3] SAIR DO JOGO");
			System.out.println("================");
			System.out.println();
			System.out.print("SELECIONE UMA OPÇÃO:");

			do {
				try {
					escolha = sc.nextInt();
					while (escolha < 1 || escolha > 3) {
						System.err.print("OPÇAO INVÁLIDA! ESCOLHA UMA POSIÇÃO VÁLIDA:");
						escolha = sc.nextInt();
					}
					jogadaValida = true;

				} catch (InputMismatchException e) {
					System.err.print("OPÇAO INVÁLIDA! ESCOLHA UMA POSIÇÃO VÁLIDA:");
					sc.next();
					jogadaValida = false;
				}
			} while (!jogadaValida);
			System.out.println();

			do {
				if (escolha == 1) {
					tabuleiro[0][0] = "1";
					tabuleiro[0][1] = "2";
					tabuleiro[0][2] = "3";
					tabuleiro[1][0] = "4";
					tabuleiro[1][1] = "5";
					tabuleiro[1][2] = "6";
					tabuleiro[2][0] = "7";
					tabuleiro[2][1] = "8";
					tabuleiro[2][2] = "9";
					repetir = false;
					jogadaValida = false;
					validado = false;
					maquinaVenceu = false;
					usuarioVenceu = false;
					bloqueio = false;
					escolha = 0;
					temp1 = 0;
					temp2 = 0;
					coluna = 0;

					System.out.println("================");
					System.out.println("   ELEMENTOS");
					System.out.println("================");
					System.out.println();
					System.out.println("MAQUINA-O");
					System.out.println("JOGADOR-X");
					System.out.println();
					System.out.println(" TABULEIRO: ");
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							System.out.print(" " + tabuleiro[i][j]);
							if (j < 2) {
								System.out.print(" |");
							}
						}
						System.out.println();
					}
					for (jogadas = 0; jogadas < 9; jogadas++) {
						if (repetir == true) {
							break;
						}
						if (jogadas % 2 == 0) {
							System.out.println();
							System.out.println("================");
							System.out.println("    SUA VEZ ");
							System.out.println("================");
							System.out.println();
							System.out.print("ESCOLHA A POSIÇÃO:");
							jogar = sc.next();

							do {
								for (int i = 0; i < 3; i++) {
									for (int j = 0; j < 3; j++) {
										if (jogar.equals(tabuleiro[i][j]) && !jogar.equals("O") && !jogar.equals("X")) {
											jogadaValida = true;
											break;
										} else {
											jogadaValida = false;
										}
									}
									if (jogadaValida == true) {
										break;
									}
								}
								if (!jogadaValida) {
									System.err.print("OPÇAO INVÁLIDA! ESCOLHA UMA POSIÇÃO VÁLIDA:");
									jogar = sc.next();
								}
							} while (!jogadaValida);

							System.out.println();
							System.out.println(" TABULEIRO: ");
							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									if (jogar.equals(tabuleiro[i][j])) {
										tabuleiro[i][j] = "X";
									}
									System.out.print(" " + tabuleiro[i][j]);
									if (j < 2) {
										System.out.print(" |");
									}
								}
								System.out.println();
							}
							System.out.println();

							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									if (tabuleiro[i][j].equals("X")) {
										temp1++;
									}
									if (temp1 == 3) {
										usuarioVenceu = true;
										break;
									}
								}
								if (!usuarioVenceu) {
									temp1 = 0;
								} else {
									temp1 = 0;
									break;
								}
							}
							if (!usuarioVenceu) {
								do {
									for (int i = 0; i < 3; i++) {
										if (tabuleiro[i][coluna].equals("X")) {
											temp1++;
										}
									}
									if (temp1 == 3) {
										usuarioVenceu = true;
										temp1 = 0;
										coluna = 0;
									} else {
										coluna++;
										temp1 = 0;
									}
								} while (usuarioVenceu == false && coluna < 3);
								coluna = 0;
							}
							if (!usuarioVenceu) {
								for (int i = 0; i < 3; i++) {
									for (int j = 0; j < 3; j++) {

										if (i == j) {
											if (tabuleiro[i][j].equals("X")) {
												temp1++;
											}
										}
										if (temp1 == 3) {
											usuarioVenceu = true;
											temp1 = 0;
										}
									}
								}
								if (!usuarioVenceu) {
									temp1 = 0;
								}
							}
							if (!usuarioVenceu) {

								for (int i = 0; i < 3; i++) {
									for (int j = 2; j >= 0; j--) {

										if (i + j == 2) {

											if (tabuleiro[i][j].equals("X")) {
												temp1++;
											}
										}
										if (temp1 == 3) {
											usuarioVenceu = true;
											temp1 = 0;
										}
									}
								}
								if (!usuarioVenceu) {
									temp1 = 0;
								}
							}
							if (usuarioVenceu) {
								System.out.println("VOCE VENCEU A PARTIDA!!!");
								System.out.println();
								break;
							}
						} else {
							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 3; j++) {
									if (tabuleiro[i][j].equals("O")) {
										temp1++;
									} else if (!tabuleiro[i][j].equals("X")) {
										temp2++;
									}
								}
								if (temp1 == 2 && temp2 == 1) {
									for (int j = 0; j < 3; j++) {
										if (!tabuleiro[i][j].equals("O") && !tabuleiro[i][j].equals("X")) {
											tabuleiro[i][j] = "O";
										}
									}
									maquinaVenceu = true;
									temp1 = 0;
									temp2 = 0;
									break;
								} else {
									temp1 = 0;
									temp2 = 0;
								}
							}
							if (!maquinaVenceu) {
								do {
									for (int i = 0; i < 3; i++) {
										if (tabuleiro[i][coluna].equals("O")) {
											temp1++;
										} else if (!tabuleiro[i][coluna].equals("X")) {
											temp2++;
										}
									}
									if (temp1 == 2 && temp2 == 1) {
										for (int i = 0; i < 3; i++) {
											if (!tabuleiro[i][coluna].equals("O")
													&& !tabuleiro[i][coluna].equals("X")) {
												tabuleiro[i][coluna] = "O";
												maquinaVenceu = true;
												coluna = 0;
												temp1 = 0;
												temp2 = 0;
												break;
											}
										}
									} else {
										coluna++;
										temp1 = 0;
										temp2 = 0;
									}

								} while (!maquinaVenceu && coluna < 3);
								coluna = 0;
							}
							if (!maquinaVenceu) {
								for (int i = 0; i < 3; i++) {
									for (int j = 0; j < 3; j++) {
										if (i == j) {
											if (tabuleiro[i][j].equals("O")) {
												temp1++;
											} else if (!tabuleiro[i][j].equals("X")) {
												temp2++;
											}
										}
									}
								}
								if (temp1 == 2 && temp2 == 1) {
									for (int i = 0; i < 3; i++) {
										for (int j = 0; j < 3; j++) {
											if (i == j) {
												if (!tabuleiro[i][j].equals("O") && !tabuleiro[i][j].equals("X")) {
													tabuleiro[i][j] = "O";
													maquinaVenceu = true;
													temp1 = 0;
													temp2 = 0;
												}
											}
										}
									}
								} else {
									temp1 = 0;
									temp2 = 0;
								}
							}
							if (!maquinaVenceu) {

								for (int i = 0; i < 3; i++) {
									for (int j = 2; j >= 0; j--) {
										if (i + j == 2) {
											if (tabuleiro[i][j].equals("O")) {
												temp1++;
											} else if (!tabuleiro[i][j].equals("X")) {
												temp2++;
											}
										}
									}
								}
								if (temp1 == 2 && temp2 == 1) {
									for (int i = 0; i < 3; i++) {
										for (int j = 2; j >= 0; j--) {
											if (i + j == 2) {
												if (!tabuleiro[i][j].equals("O") && !tabuleiro[i][j].equals("X")) {
													tabuleiro[i][j] = "O";
													maquinaVenceu = true;
													temp1 = 0;
													temp2 = 0;
												}
											}
										}
									}
								} else {
									temp1 = 0;
									temp2 = 0;
								}
							}
							if (maquinaVenceu) {
								System.out.println();
								System.out.println("===============");
								System.out.println(" VEZ DA MÁQUINA");
								System.out.println("===============");
								System.out.println();
								System.out.println(" TABULEIRO: ");
								for (int i = 0; i < 3; i++) {
									for (int j = 0; j < 3; j++) {
										System.out.print(" " + tabuleiro[i][j]);
										if (j < 2) {
											System.out.print(" |");
										}
									}
									System.out.println();
								}
							} else {
								for (int i = 0; i < 3; i++) {
									for (int j = 0; j < 3; j++) {
										if (tabuleiro[i][j].equals("X")) {
											temp1++;
										} else if (!tabuleiro[i][j].equals("O")) {
											temp2++;
										}
									}
									if (temp1 == 2 && temp2 == 1) {
										for (int j = 0; j < 3; j++) {
											if (!tabuleiro[i][j].equals("O") && !tabuleiro[i][j].equals("X")) {
												tabuleiro[i][j] = "O";
											}
										}
										bloqueio = true;
										temp1 = 0;
										temp2 = 0;
										break;
									} else {
										temp1 = 0;
										temp2 = 0;
									}
									if (bloqueio) {
										break;
									}
								}
								if (!bloqueio) {
									for (int i = 0; i < 3; i++) {
										for (int j = 0; j < 3; j++) {
											if (i == j) {
												if (tabuleiro[i][j].equals("X")) {
													temp1++;
												} else if (!tabuleiro[i][j].equals("O")) {
													temp2++;
												}
											}
										}
									}
									if (temp1 == 2 && temp2 == 1) {
										for (int i = 0; i < 3; i++) {
											for (int j = 0; j < 3; j++) {
												if (i == j) {
													if (!tabuleiro[i][j].equals("O") && !tabuleiro[i][j].equals("X")) {
														tabuleiro[i][j] = "O";
														bloqueio = true;
														temp1 = 0;
														temp2 = 0;
													}
												}
											}
										}
									} else {
										temp1 = 0;
										temp2 = 0;
									}
								}
								if (bloqueio) {
									System.out.println("===============");
									System.out.println(" VEZ DA MÁQUINA");
									System.out.println("===============");
									System.out.println();
									for (int i = 0; i < 3; i++) {
										for (int j = 0; j < 3; j++) {
											System.out.print(" " + tabuleiro[i][j]);
											if (j < 2) {
												System.out.print(" |");
											}
										}
										System.out.println();
									}
									bloqueio = false;
								} else {
									System.out.println();
									System.out.println("================");
									System.out.println(" VEZ DA MÁQUINA");
									System.out.println("================");
									System.out.println();
									System.out.println(" TABULEIRO: ");
									validado = false;
									for (int i = 0; i < 3; i++) {
										for (int j = 0; j < 3; j++) {
											if (validado == false) {
												if (!tabuleiro[i][j].equals("X") && !tabuleiro[i][j].equals("O")) {
													tabuleiro[i][j] = "O";
													System.out.print(" " + tabuleiro[i][j]);
													if (j < 2) {
														System.out.print(" |");
														validado = true;
													} else {
														validado = true;
													}
												} else {
													System.out.print(" " + tabuleiro[i][j]);
													if (j < 2) {
														System.out.print(" |");
													}
												}
											} else {
												System.out.print(" " + tabuleiro[i][j]);
												if (j < 2) {
													System.out.print(" |");
												}
											}
										}
										System.out.println();
									}
								}
							}
							if (maquinaVenceu) {
								System.out.println();
								System.out.println("MÁQUINA VENCEU A PARTIDA!");
								System.out.println();
								break;
							}
						}
						if (jogadas == 8) {
							System.out.println();
							System.out.println("HOUVE UM EMPATE!");
							System.out.println();
							empate = true;
							break;
						}
					}
					if (empate || maquinaVenceu || usuarioVenceu) {
						System.out.println("1-JOGAR NOVAMENTE | 2-INFORMAÇÕES | 3-SAIR DO JOGO");
						System.out.println();
						System.out.print("SELECIONE UMA OPÇÃO:");
						do {
							try {
								escolha = sc.nextInt();
								System.out.println();

								while (escolha < 1 || escolha > 3) {
									System.err.print("OPÇAO INVÁLIDA! ESCOLHA UMA POSIÇÃO VÁLIDA:");
									escolha = sc.nextInt();
								}
								jogadaValida = true;

							} catch (InputMismatchException e) {
								System.err.print("OPÇAO INVÁLIDA! ESCOLHA UMA POSIÇÃO VÁLIDA:");
								sc.next();
								jogadaValida = false;
							}
						} while (!jogadaValida);
					}
				}
				if (escolha == 1) {
					repetir = true;
				}
				if (escolha == 2) {
					System.out.println("======================= INFORMAÇÕES =======================");
					System.out.println();
					System.out.println("1. MAQUINA-O");
					System.out.println("   JOGADOR-X");
					System.out.println();
					System.out.println("2. JOGADOR COMEÇA JOGANDO");
					System.out.println();
					System.out.println(" 1 | 2 | 3");
					System.out.println(" 4 | 5 | 6    <- USÚARIO DIGITA O NÚMERO DA POSIÇÃO QUE DESEJA JOGAR");
					System.out.println(" 7 | 8 | 9");
					System.out.println();
					System.out.println(" 1 | X | 3");
					System.out.println(" 4 | 5 | 6    <- A ESCOLHA FOI O NÚMERO 2");
					System.out.println(" 7 | 8 | 9");
					System.out.println();
					System.out.println(" O | X | 3    <- MÁQUINA JOGA AUTOMATICAMENTE");
					System.out.println(" 4 | 5 | 6");
					System.out.println(" 7 | 8 | 9");
					System.out.println();
					System.out.println("3. VENCE QUEM CONSEGUIR 3 SÍMBOLOS IGUAIS:");
					System.out.println("    LINHA, COLUNA OU DIAGONAL.");
					System.out.println();
					System.out.println("4. ENCHER O TABULEIRO = EMPATE");
					System.out.println();
					System.out.println("===========================================================");
					System.out.println();
					System.out.println("[1] JOGAR AGORA");
					System.out.println("[2] SAIR DO JOGO");
					System.out.println();
					System.out.print("SELECIONE UMA OPÇÃO:");

					do {
						try {

							escolha = sc.nextInt();

							while (escolha < 1 || escolha > 2) {
								System.err.print("OPÇAO INVÁLIDA! ESCOLHA UMA POSIÇÃO VÁLIDA:");
								escolha = sc.nextInt();
							}
							jogadaValida = true;

						} catch (InputMismatchException e) {
							System.err.print("OPÇAO INVÁLIDA! ESCOLHA UMA POSIÇÃO VÁLIDA:");
							sc.next();
							jogadaValida = false;
						}
					} while (!jogadaValida);

					if (escolha == 1) {
						repetir = true;
					} else {
						System.out.println();
						System.out.print("FIM DE JOGO :)");

						sc.close();
						return;
					}
				}
				if (escolha == 3) {
					System.out.print("FIM DE JOGO :)");

					sc.close();
					return;
				}
			} while (repetir);
		} while (!repetir);

		sc.close();
	}
}