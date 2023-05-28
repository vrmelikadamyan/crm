package com.tucanoo.crm.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucanoo.crm.data.dto.RequestDto;
import com.tucanoo.crm.data.entities.Customer;
import com.tucanoo.crm.data.entities.Request;
import com.tucanoo.crm.data.repositories.CustomerRepository;
import com.tucanoo.crm.data.repositories.RequestRepository;
import com.tucanoo.crm.services.CustomerService;
import com.tucanoo.crm.services.RequestService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerWebController {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final RequestService requestService;

    @Autowired
    private final RequestRepository requestRepository;

    public CustomerWebController(CustomerRepository customerRepository, CustomerService customerService, RequestService requestService, RequestRepository requestRepository) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.requestService = requestService;
        this.requestRepository = requestRepository;
    }


    @GetMapping
    public String index() {
        return "customer/index.html";
    }

//    @RequestMapping(value = "/data_for_datatable", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public String getDataForDatatable(@RequestParam Map<String, Object> params) {
//        int draw = params.containsKey("draw") ? Integer.parseInt(params.get("draw").toString()) : 1;
//        int length = params.containsKey("length") ? Integer.parseInt(params.get("length").toString()) : 30;
//        int start = params.containsKey("start") ? Integer.parseInt(params.get("start").toString()) : 30;
//        int currentPage = start / length;
//
//        String sortName = "id";
//        String dataTableOrderColumnIdx = params.get("order[0][column]").toString();
//        String dataTableOrderColumnName = "columns[" + dataTableOrderColumnIdx + "][data]";
//        if (params.containsKey(dataTableOrderColumnName))
//            sortName = params.get(dataTableOrderColumnName).toString();
//        String sortDir = params.containsKey("order[0][dir]") ? params.get("order[0][dir]").toString() : "asc";
//
//        Sort.Order sortOrder = new Sort.Order((sortDir.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC), sortName);
//        Sort sort = Sort.by(sortOrder);
//
//        Pageable pageRequest = PageRequest.of(currentPage,
//                length,
//                sort);
//
//        String queryString = (String) (params.get("search[value]"));
//
//        Page<Customer> customers = customerService.getCustomersForDatatable(queryString, pageRequest);
//
//        long totalRecords = customers.getTotalElements();
//
//        List<Map<String, Object>> cells = new ArrayList<>();
//        customers.forEach(customer -> {
//            Map<String, Object> cellData = new HashMap<>();
//            cellData.put("id", customer.getId());
//            cellData.put("firstName", customer.getFirstName());
//            cellData.put("lastName", customer.getLastName());
//            cellData.put("emailAddress", customer.getEmailAddress());
//            cellData.put("city", customer.getCity());
//            cellData.put("country", customer.getCountry());
//            cellData.put("phoneNumber", customer.getPhoneNumber());
//            cells.add(cellData);
//        });
//
//        Map<String, Object> jsonMap = new HashMap<>();
//
//        jsonMap.put("draw", draw);
//        jsonMap.put("recordsTotal", totalRecords);
//        jsonMap.put("recordsFiltered", totalRecords);
//        jsonMap.put("data", cells);
//
//        String json = null;
//        try {
//            json = new ObjectMapper().writeValueAsString(jsonMap);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        return json;
//    }


    @RequestMapping(value = "/data_for_datatable", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getDataForDatatable(@RequestParam Map<String, Object> params) {
        int draw = params.containsKey("draw") ? Integer.parseInt(params.get("draw").toString()) : 1;
        int length = params.containsKey("length") ? Integer.parseInt(params.get("length").toString()) : 30;
        int start = params.containsKey("start") ? Integer.parseInt(params.get("start").toString()) : 30;
        int currentPage = start / length;

        String sortName = "id";
        String dataTableOrderColumnIdx = params.get("order[0][column]").toString();
        String dataTableOrderColumnName = "columns[" + dataTableOrderColumnIdx + "][data]";
        if (params.containsKey(dataTableOrderColumnName))
            sortName = params.get(dataTableOrderColumnName).toString();
        String sortDir = params.containsKey("order[0][dir]") ? params.get("order[0][dir]").toString() : "asc";

        Sort.Order sortOrder = new Sort.Order((sortDir.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC), sortName);
        Sort sort = Sort.by(sortOrder);

        Pageable pageRequest = PageRequest.of(currentPage,
                length,
                sort);

        String queryString = (String) (params.get("search[value]"));

//        Page<Customer> customers = customerService.getCustomersForDatatable(queryString, pageRequest);
        Page<Request> requests = requestService.getRequestsForDatatable(queryString, params.get("filter").toString(), pageRequest);

        long totalRecords = requests.getTotalElements();

        // TODO сделать нормальные null обработки
//        List<Map<String, Object>> cells = new ArrayList<>();
//        requests.forEach(request -> {
//            Map<String, Object> cellData = new HashMap<>();
//            cellData.put("id", request.getId());
//            cellData.put("name", request.getName());
//            cellData.put("type", request.getType());
////            cellData.put("fio", String.format("%s %s", request.getCustomer().getFirstName(), request.getCustomer().getLastName()));
//            cellData.put("fio", request.getCustomer() != null ? request.getCustomer().getFullName() : null);
//            cellData.put("status", request.getStatus());
//            cellData.put("phoneNumber", request.getCustomer() == null ? request.getPhoneNumber() : null);
//            cellData.put("startDate", request.getStartDate().toLocalDate() + " " + request.getStartDate().toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
//            cellData.put("grade", request.getGrade());
//            cells.add(cellData);
//        });

        List<Map<String, Object>> cells = new ArrayList<>();
        requests.forEach(request -> {
            Map<String, Object> cellData = new HashMap<>();
            cellData.put("id", request.getId());
            cellData.put("name", request.getName());
            cellData.put("type", request.getType());
//            cellData.put("fio", String.format("%s %s", request.getCustomer().getFirstName(), request.getCustomer().getLastName()));
            cellData.put("fio", request.getFullName());
            cellData.put("status", request.getStatus());
            cellData.put("phoneNumber", request.getPhoneNumber());
            cellData.put("startDate", request.getStartDate().toLocalDate() + " " + request.getStartDate().toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            cellData.put("grade", request.getGrade());
            cells.add(cellData);
        });

        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap.put("draw", draw);
        jsonMap.put("recordsTotal", totalRecords);
        jsonMap.put("recordsFiltered", totalRecords);
        jsonMap.put("data", cells);

        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(jsonMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    @RequestMapping(value = "/data_for_datatable/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getDataForDatatableAll(@RequestParam Map<String, Object> params) {
        params.put("filter", "all");
        return getDataForDatatable(params);
    }

    @RequestMapping(value = "/data_for_datatable/registered", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getDataForDatatableRegistered(@RequestParam Map<String, Object> params) {
        params.put("filter", "REGISTERED");
        return getDataForDatatable(params);
    }

    @RequestMapping(value = "/data_for_datatable/in-progress", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getDataForDatatableInProgress(@RequestParam Map<String, Object> params) {
        params.put("filter", "IN_PROGRESS");
        return getDataForDatatable(params);
    }

    @RequestMapping(value = "/data_for_datatable/completed", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getDataForDatatableCompleted(@RequestParam Map<String, Object> params) {
        params.put("filter", "COMPLETED");
        return getDataForDatatable(params);
    }

//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable String id, Model model) {
//        Customer customerInstance = customerRepository.findById(Long.valueOf(id)).get();
//
//        model.addAttribute("customerInstance", customerInstance);
//
//        return "/customer/edit.html";
//    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Request requestInstance = requestRepository.findById(Long.valueOf(id)).get();

        model.addAttribute("requestInstance", requestInstance);

        return "customer/edit.html";
    }

//    @PostMapping("/update")
//    public String update(@Valid @ModelAttribute("customerInstance") Customer customerInstance,
//                         BindingResult bindingResult,
//                         Model model,
//                         RedirectAttributes atts) {
//        if (bindingResult.hasErrors()) {
//            return "/customer/edit.html";
//        } else {
//            if (customerRepository.save(customerInstance) != null)
//                atts.addFlashAttribute("message", "Customer updated successfully");
//            else
//                atts.addFlashAttribute("message", "Customer update failed.");
//
//            return "redirect:/customer/";
//        }
//    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("requestInstance") Request requestInstance,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes atts) {
        if (bindingResult.hasErrors()) {
            return "/customer/edit.html";
        } else {
            if (requestRepository.save(requestInstance) != null)
                atts.addFlashAttribute("message", "Заявка обновлена");
            else
                atts.addFlashAttribute("message", "Не удалось обновить заявку");

//            return "redirect:customer";
            return "redirect:/";
        }
    }

//    @GetMapping("/create")
//    public String create(Model model)
//    {
//        model.addAttribute("customerInstance", new Customer());
//        return "/customer/create.html";
//    }

    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("requestDto", new RequestDto());
        return "customer/create.html";
    }

//    @PostMapping("/save")
//    public String save(@Valid @ModelAttribute("customerInstance") Customer customerInstance,
//                       BindingResult bindingResult,
//                       Model model,
//                       RedirectAttributes atts) {
//        if (bindingResult.hasErrors()) {
//            return "/customer/create.html";
//        } else {
//            if (customerRepository.save(customerInstance) != null)
//                atts.addFlashAttribute("message", "Customer created successfully");
//            else
//                atts.addFlashAttribute("message", "Customer creation failed.");
//
//            return "redirect:/customer/";
//        }
//    }

    @PostMapping("/save")
    public String save(@ModelAttribute("requestDto") RequestDto requestDto,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes atts) {
        if (bindingResult.hasErrors()) {
            return "customer/create.html";
        } else {
            Request request = new Request();
            request.setName(requestDto.getName());
            request.setDescription(requestDto.getDescription());
            request.setType(requestDto.getType());
            request.setFullName(requestDto.getFullName());
            request.setStartDate(LocalDateTime.now().toString());
            request.setStatus("Зарегистрирована");
            request.setEmailAddress(requestDto.getEmailAddress());
            request.setPhoneNumber(requestDto.getPhoneNumber());
            if (requestRepository.save(request) != null)
                atts.addFlashAttribute("message", "Заявка успешно создана");
            else
                atts.addFlashAttribute("message", "Ошибка создания заявки");

//            return "redirect:customer";
            return "redirect:/";
        }
    }


//    @PostMapping("/delete")
//    public String delete(@RequestParam Long id, RedirectAttributes atts) {
//        Customer customerInstance = customerRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Customer Not Found:" + id));
//
//        customerRepository.delete(customerInstance);
//
//        atts.addFlashAttribute("message", "Customer deleted.");
//
//        return "redirect:/customer/";
//    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes atts) {
        Request requestInstance = requestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Заявка не найдена:" + id));

        requestRepository.delete(requestInstance);

        atts.addFlashAttribute("message", "Заявка удалена");

//        return "redirect:customer";
        return "redirect:/";
    }

}
