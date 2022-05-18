from tkinter import messagebox
from tkinter import *
from matplotlib import pyplot as plot
from numpy import double
from sympy import maximum, symbols, parse_expr


def change(value,function_x):
    x=symbols('x')
    a = parse_expr(function_x)
    b = a.subs(x,value)
    return b
    

def plot_function():
    minimum_value = int(min_value_entry.get())
    maximum_value = int(max_value_entry.get())
    function = function_entry.get()
    function = function.replace("^","**")
    if minimum_value > maximum_value:
        messagebox.showerror("Limited Error","Minimum cannot be greater than Maximum!")
        return
    x_axis=[]
    y_axis=[]

    for values in range(minimum_value,maximum_value+1):
        x_axis.append(values)
    
    for values in x_axis:
        y_axis.append(change(values, function))

    plot.plot(x_axis, y_axis)
    plot.xlabel('x-axis')
    plot.ylabel('y-axis')
    plot.show()






root = Tk()
root.title("Function Plotter")
root.geometry("600x400")

#welcome message
welcome_msg = Label(root,text="Welcome to the Function Plotter",height=5,font=(10))
welcome_msg.pack(side=TOP)

#label min
min_value = Label(text="Minimum Value")
min_value.pack()
min_value.place(x=120,y=150)

#text box
min_value_entry = Entry()
min_value_entry.pack()
min_value_entry.place(x=120,y=180)


#label max
max_value = Label(text="Minimum Value")
max_value.pack()
max_value.place(x=350,y=150)

#text box
max_value_entry = Entry()
max_value_entry.pack()
max_value_entry.place(x=350,y=180)


#label for Function box
function_label = Label(text="Function")
function_label.pack()
function_label.place(x=210,y=240,width=180)

#text box
function_entry = Entry()
function_entry.pack()
function_entry.place(x=210,y=270,width=180)




#plot button
plot_btn = Button(root,text="Plot",command=plot_function)
plot_btn.pack()
plot_btn.place(x=255,y=330,width=90)




root.mainloop()
