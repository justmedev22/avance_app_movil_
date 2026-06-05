using backend_avance.Models;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

 // 👇 Hacemos que escuche en todas las IPs y puerto 5000
builder.WebHost.UseUrls("http://0.0.0.0:5000");

var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
builder.Services.AddDbContext<bdavancetechContext>(options => options.UseMySql(connectionString, Microsoft.EntityFrameworkCore.ServerVersion.AutoDetect(connectionString)));

// Configuracion de CORS
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll", policy =>
    {
        policy.AllowAnyOrigin()
              .AllowAnyMethod()
              .AllowAnyHeader();
    });
});

// Add services to the container.
// Learn more about configuring OpenAPI at https://aka.ms/aspnet/openapi
builder.Services.AddOpenApi();

// Servicios necesarios
builder.Services.AddAuthorization(); // ← AGREGAR
builder.Services.AddControllers(); // ← AGREGAR

// Configuracion de Swagger
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI(c =>
    {
        c.SwaggerEndpoint("/swagger/v1/swagger.json", "Mi API v1");
        c.RoutePrefix = string.Empty; // <--Accede en /swagger
    });
}

app.UseHttpsRedirection();

// Usar CORS antes de Authorization
app.UseCors("AllowAll");

app.UseAuthorization(); //Se Agrego
app.MapControllers(); //Se Agrego

app.Run();
