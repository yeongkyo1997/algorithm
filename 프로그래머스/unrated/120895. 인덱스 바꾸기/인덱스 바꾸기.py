def solution(my_string, num1, num2):
    n1 = my_string[num1]
    n2 = my_string[num2]
    
    my_string = my_string[:num1] + n2 + my_string[num1 + 1:]
    my_string = my_string[:num2] + n1 + my_string[num2 + 1:]
    
    return my_string