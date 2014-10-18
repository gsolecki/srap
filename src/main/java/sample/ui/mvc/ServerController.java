package sample.ui.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sample.ui.domain.Server;
import sample.ui.repo.ServerRepository;

@Controller
@RequestMapping("/")
public class ServerController {

	private final ServerRepository serverRepository;

	@Autowired
	public ServerController(ServerRepository serverRepository) {
		this.serverRepository = serverRepository;
	}

	@RequestMapping
	public ModelAndView list() {
		return new ModelAndView("server/list", "servers", serverRepository.findAll());
	}

	@RequestMapping("{id}")
	public ModelAndView view(@PathVariable("id") Server server) {
		return new ModelAndView("server/view", "server", server);
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(@ModelAttribute Server server) {
		return "server/form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid Server server, BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return new ModelAndView("server/form", "formErrors", result.getAllErrors());
		}

		server = serverRepository.save(server);
		redirect.addFlashAttribute("globalServer", "Successfully created a new server");
		return new ModelAndView("redirect:/{server.id}", "server.id", server.getId());
	}

}
