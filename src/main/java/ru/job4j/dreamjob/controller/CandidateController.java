package ru.job4j.dreamjob.controller;

import lombok.extern.slf4j.Slf4j;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.dreamjob.dto.FileDto;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.service.CandidateService;
import ru.job4j.dreamjob.service.CityService;

/**
 * Класс-контроллер для работы с кандидатами {@link Candidate}
 *
 * @author Artem Chernikov
 * @version 1.0
 * @since 15.01.2023
 */
@ThreadSafe
@Slf4j
@Controller
@RequestMapping("/candidates")
public class CandidateController {
    /**
     * Поле {@link CandidateService} - класс-сервис по работе с кандидатами
     */
    private final CandidateService candidateService;
    /**
     * Поле {@link CityService} - класс-сервис по работе с городами
     */
    private final CityService cityService;

    public CandidateController(CandidateService candidateService, CityService cityService) {
        this.candidateService = candidateService;
        this.cityService = cityService;
    }

    /**
     * Метод используется для вывода в браузере отображения всех кандидатов
     *
     * @param model - {@link Model}
     * @return - возвращает отображение со всеми кандидатами
     */
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("candidates", candidateService.findAll());
        return "candidates/list";
    }

    /**
     * Метод используется для вывода в браузере отображения с созданием нового кандидата
     *
     * @return - возвращает отображение с созданием нового кандидата
     */
    @GetMapping("/create")
    public String getCreationPage(Model model) {
        model.addAttribute("cities", cityService.findAll());
        return "candidates/create";
    }

    /**
     * Метод используется для сохранения нового кандидата в хранилище
     *
     * @param candidate - кандидат
     * @return - возвращает отображение со списком всех кандидатов
     */
    @PostMapping("/create")
    public String create(@ModelAttribute Candidate candidate, @RequestParam MultipartFile file,
                         Model model) {
        try {
            candidateService.save(candidate, new FileDto(file.getOriginalFilename(), file.getBytes()));
            return "redirect:/candidates";
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            model.addAttribute("message", exception.getMessage());
            return "errors/404";
        }
    }

    /**
     * Метод используется для поиска кандидата {@link Candidate} по id и вывода отображения
     * с возможностью просмотра, редактирования и удаления кандидата
     *
     * @param model - {@link Model}
     * @param id    - id кандидата
     * @return - возвращает отображение с возможностью просмотра, редактирования и удаления кандидата
     */
    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var candidateOptional = candidateService.findById(id);
        if (candidateOptional.isEmpty()) {
            model.addAttribute("message", "Кандидат с указанным идентификатором не найден");
            return "errors/404";
        }
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("candidate", candidateOptional.get());
        return "candidates/one";
    }

    /**
     * Метод используется для обновления данных о кандидате
     *
     * @param candidate - кандидат
     * @param model     - {@link Model}
     * @return - возвращает отображение со списком всех кандидатов
     */
    @PostMapping("/update")
    public String update(@ModelAttribute Candidate candidate, @RequestParam MultipartFile file,
                         Model model) {
        try {
            var isUpdated = candidateService.update(candidate, new FileDto(file.getOriginalFilename(), file.getBytes()));
            if (!isUpdated) {
                model.addAttribute("message", "Кандидат с указанным идентификатором не найден");
                return "errors/404";
            }
            return "redirect:/candidates";
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            model.addAttribute("message", exception.getMessage());
            return "errors/404";
        }
    }

    /**
     * Метод используется для удаления кандидата
     *
     * @param model - {@link Model}
     * @param id    - id кандидата
     * @return - возвращает отображение со списком всех кандидатов
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        var isDeleted = candidateService.deleteById(id);
        if (!isDeleted) {
            model.addAttribute("message", "Кандидат с указанным идентификатором не найден");
            return "errors/404";
        }
        return "redirect:/candidates";
    }
}
