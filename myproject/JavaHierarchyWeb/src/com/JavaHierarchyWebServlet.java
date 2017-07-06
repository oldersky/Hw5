package com;
import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class JavaHierarchyWebServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		int reqMoney = 0, money = 40000;
	
		
		ArtistGroup fireArt = new ArtistGroup();
		String fireArtistSt;
		int fansNum;
		int poiNum;
		int staffNum;
		int ropeNum;
		int minutes;
		
		try {
			fireArtistSt = req.getParameter("artistGroup");
			fansNum = Integer.parseInt(req.getParameter("fans"));
			poiNum = Integer.parseInt(req.getParameter("poi"));
			staffNum = Integer.parseInt(req.getParameter("staff"));
			ropeNum = Integer.parseInt(req.getParameter("rope"));
			minutes = Integer.parseInt(req.getParameter("minutes"));
		} catch (NumberFormatException e) {
			resp.getWriter().print("Некорректный ввод. Все поля должны быть заполнены."
					+ "Количество минут, песен и атистов должно быть целым.");
			return;
		}

		
		boolean fireArtEnough = true, danceArtEnough = true, enoughMoney = true;
		
		
		for (int i = 0; i < ArtistGroup.numberOfGroups; i++) {
			if (fireArt.groupName[i].equals(fireArtistSt)) {
				if (!(fireArt.enoughArtists(i, fansNum, poiNum, staffNum, ropeNum))) {
					fireArtEnough = false;
					resp.getWriter().println("В выбранной вами группе артистов "
							+ "Огненного шоу нет нужного числа актеров.\n");
				} else {
					reqMoney += fireArt.priceOfMinute[i] * minutes;
				}
			}
		}
		
		DanceArtistGroup danceArt = new DanceArtistGroup();
		String danceArtistSt;
		int numberOfDancers;
		
		try {
			danceArtistSt = req.getParameter("danceArtistGroup");
			numberOfDancers = Integer.parseInt(req.getParameter("dancersNumber"));
		} catch (NumberFormatException e) {
			resp.getWriter().print("Некорректный ввод. Все поля должны быть заполнены."
					+ "Количество минут, песен и атистов должно быть целым.");
			return;
		}
		
		
		for (int i = 0; i < danceArt.numberOfGroups; i++) {
			if (danceArt.groupName[i].equals(danceArtistSt)) {
				if (!(danceArt.enougArtists(i, numberOfDancers))) {
					danceArtEnough = false;
					resp.getWriter().println("В выбранной вами группе "
							+ "нет нужного числа танцоров.\n");
				} else {
					reqMoney += danceArt.cost(i, numberOfDancers); 
				}
			}
		}
		
		SingGroupArtist singArt = new SingGroupArtist();
		String singArtistSt;
		int numberOfSongs;
		
		try {
			singArtistSt = req.getParameter("singArtistGroup");
			numberOfSongs = Integer.parseInt(req.getParameter("numberOfSongs"));
		} catch (NumberFormatException e) {
			resp.getWriter().print("Некорректный ввод. Все поля должны быть заполнены."
					+ "Количество минут, песен и артистов должно быть целым.");
			return;
		}

		
		for (int i = 0; i < danceArt.numberOfGroups; i++) {
			if (singArt.groupName[i].equals(singArtistSt)) {
				reqMoney += singArt.priceOfSongs[i] * numberOfSongs;
			}
		}
		
		if (reqMoney > money) {
			enoughMoney = false;
			resp.getWriter().println("Вам не хватает бюджета!\n");
			resp.getWriter().println("Расходы на мерояприятие составляют: " + reqMoney + " руб.");
		}
		
		if (enoughMoney && fireArtEnough && danceArtEnough) {
			resp.getWriter().println("Выступления состоятся!\n");
			resp.getWriter().println("Расходы на мерояприятие составят: " + reqMoney + " руб.");
		}
	}
}
